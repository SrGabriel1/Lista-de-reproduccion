/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listamusicalnegocio;

import entidades.Cancion;
import java.io.File;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Gabriel
 */
public class ReproductorBO {
 private List<Cancion> canciones;
    private MediaPlayer mediaPlayer;
    private int indiceActual = 0;
    private boolean isJavaFXInitialized = false;

    public ReproductorBO(List<Cancion> canciones) {
        this.canciones = canciones;
        initializeJavaFX();
    }

    private void initializeJavaFX() {
        if (!isJavaFXInitialized) {
            Platform.startup(() -> {});  // Inicializa el toolkit de JavaFX
            isJavaFXInitialized = true;
        }
    }

    public void reproducir() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();  // Detiene la reproducción anterior
        }

        // Obtiene la ruta de la canción actual
        Cancion cancionActual = canciones.get(indiceActual);
        String rutaArchivo = cancionActual.getDireccion();

        // Carga el archivo MP3 y crea el reproductor
        Media media = new Media(new File(rutaArchivo).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        // Agrega listeners para manejar eventos
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
            System.out.println("Reproduciendo: " + cancionActual.getNombreCancion());
        });

        mediaPlayer.setOnEndOfMedia(() -> {
            System.out.println("Reproducción terminada: " + cancionActual.getNombreCancion());
            siguiente();  // Reproduce la siguiente canción automáticamente si es necesario
        });

        mediaPlayer.setOnError(() -> {
            System.out.println("Error en la reproducción: " + mediaPlayer.getError().getMessage());
        });

       
    }

    public void pausar() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            System.out.println("Canción pausada.");
        }
    }

    public void siguiente() {
        if (indiceActual < canciones.size() - 1) {
            indiceActual++;
        } else {
            indiceActual = 0;  // Vuelve al principio si es la última canción
        }
        reproducir();
    }

    public void anterior() {
        if (indiceActual > 0) {
            indiceActual--;
        } else {
            indiceActual = canciones.size() - 1;  // Va a la última si es la primera canción
        }
        reproducir();
    }
}
