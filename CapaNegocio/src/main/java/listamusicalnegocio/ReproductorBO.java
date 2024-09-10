/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listamusicalnegocio;

import entidades.Cancion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Gabriel
 */
public class ReproductorBO {

    private Player player;
    private List<Cancion> listaCanciones;
    private int indiceActual = 0;
    private boolean enPausa = false;
    private Thread hiloReproduccion;

    // Constructor que recibe la lista de canciones
    public ReproductorBO(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    // Método para reproducir la canción actual
    public void reproducir() throws FileNotFoundException {
        if (enPausa) {
            // Si está en pausa, solo resume la reproducción
            enPausa = false;
            synchronized (hiloReproduccion) {
                hiloReproduccion.notify();
            }
        } else {
            reproducirCancion(indiceActual);
        }
    }

    // Método privado para reproducir una canción específica
    private void reproducirCancion(int indice) throws FileNotFoundException {
        if (indice >= 0 && indice < listaCanciones.size()) {
            try {
                Cancion cancion = listaCanciones.get(indice);
                FileInputStream archivo = new FileInputStream(cancion.getDireccion());
                player = new Player(archivo);

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

    // Método para detener la canción
    public void detener() {
        if (player != null) {
            player.close();
        }
    }

    // Método para ir a la siguiente canción
    public void siguiente() throws FileNotFoundException {
        detener();
        if (indiceActual < listaCanciones.size() - 1) {
            indiceActual++;
            reproducirCancion(indiceActual);
        }
    }

    // Método para ir a la canción anterior
    public void anterior() throws FileNotFoundException {
        detener();
        if (indiceActual > 0) {
            indiceActual--;
            reproducirCancion(indiceActual);
        }
    }

    // Método para obtener la canción actual
    public Cancion getCancionActual() {
        return listaCanciones.get(indiceActual);
    }
}
