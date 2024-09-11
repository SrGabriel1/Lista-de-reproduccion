package listamusicalnegocio;

import entidades.Cancion;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ReproductorBO {

    private AdvancedPlayer player;
    private List<Cancion> listaCanciones;
    private int indiceActual = 0;
    private boolean enPausa = false;
    private FileInputStream archivo;
    private long pauseLocation = 0;
    private long songTotalLength = 0;
    private Thread hiloReproduccion;

    private int framePosition = 0;


    public ReproductorBO(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public void reproducir() throws FileNotFoundException, JavaLayerException, IOException {
        if (enPausa) {

            resumirCancion();

            // Si está en pausa, solo resume la reproducción
            enPausa = false;
            synchronized (hiloReproduccion) {
                hiloReproduccion.notify();
            }

        } else {
            reproducirCancion(indiceActual);
        }
    }

    private void reproducirCancion(int indice) throws FileNotFoundException, JavaLayerException, IOException {
        if (indice >= 0 && indice < listaCanciones.size()) {
            detener();
            Cancion cancion = listaCanciones.get(indice);
            archivo = new FileInputStream(cancion.getDireccion());
            songTotalLength = archivo.available();
            player = new AdvancedPlayer(archivo);
            player.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent evt) {
                    framePosition = evt.getFrame();
                }
            });


            hiloReproduccion = new Thread(() -> {
                try {
                    player.play(framePosition, Integer.MAX_VALUE);
                } catch (JavaLayerException e) {
                    System.out.println("Error al reproducir: " + e.getMessage());
                }
            });
            hiloReproduccion.start();
            enPausa = false;
        }
    }

    public void pausar() throws IOException {
        if (player != null) {
            try {
                pauseLocation = archivo.available();
                player.close();
                enPausa = true;
                System.out.println("Reproducción pausada.");
            } catch (Exception e) {
                System.out.println("Error al pausar: " + e.getMessage());
            }

                // Correr en un hilo separado para permitir controlar la reproducción
                hiloReproduccion = new Thread(() -> {
                    try {
                        player.play();
                    } catch (JavaLayerException e) {
                        System.out.println("Error al reproducir: " + e.getMessage());
                    }
                });
                hiloReproduccion.start();

            } catch (JavaLayerException e) {
                System.out.println("Error al cargar el archivo MP3: " + e.getMessage());
            }
        }
    }

    // Método para pausar la canción
    public void pausar() {
        if (hiloReproduccion != null && player != null) {
            enPausa = true;
            hiloReproduccion.suspend();

        }
    }

    private void resumirCancion() throws FileNotFoundException, JavaLayerException, IOException {
        if (enPausa) {
            archivo = new FileInputStream(listaCanciones.get(indiceActual).getDireccion());
            archivo.skip(songTotalLength - pauseLocation);
            player = new AdvancedPlayer(archivo);
            player.setPlayBackListener(new PlaybackListener() {
                @Override
                public void playbackFinished(PlaybackEvent evt) {
                    framePosition = evt.getFrame();
                }
            });

            hiloReproduccion = new Thread(() -> {
                try {
                    player.play(framePosition, Integer.MAX_VALUE);
                } catch (JavaLayerException e) {
                    System.out.println("Error al reanudar: " + e.getMessage());
                }
            });
            hiloReproduccion.start();
            enPausa = false;
        }
    }

    public void detener() {
        if (player != null) {
            player.close();

            enPausa = false;
            try {
                if (archivo != null) {
                    archivo.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }

        }
    }

    public void siguiente() throws FileNotFoundException, JavaLayerException, IOException {
        if (indiceActual < listaCanciones.size() - 1) {
            indiceActual++;
            reproducirCancion(indiceActual);
        }
    }

    public void anterior() throws FileNotFoundException, JavaLayerException, IOException {
        if (indiceActual > 0) {
            indiceActual--;
            reproducirCancion(indiceActual);
        }
    }

    public Cancion getCancionActual() {
        return listaCanciones.get(indiceActual);
    }
}

