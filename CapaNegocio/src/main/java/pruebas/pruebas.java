/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import daos.CancionDAO;
import entidades.Cancion;
import entidades.ListaReproduccion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import listamusicalnegocio.ListaReproduccionBO;
import listamusicalnegocio.ReproductorBO;

/**
 *
 * @author Gabriel
 */
public class pruebas {

    public static void main(String[] args) throws FileNotFoundException, JavaLayerException, IOException {
//       try {
        // Crear algunas canciones de ejemplo
        CancionDAO cancionDAO = new CancionDAO();
        List<Cancion> listaCanciones = cancionDAO.obtenerCanciones();
        ReproductorBO reproductor = new ReproductorBO(listaCanciones);

        // Reproducir la canción actual
        System.out.println("Reproduciendo canción...");
        reproductor.reproducir();
        reproductor.siguiente();
        // Esperar 3 segundos
        try {
            Thread.sleep(3000); // 3000 milisegundos = 3 segundos
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida: " + e.getMessage());
        }

        // Pausar la canción
        System.out.println("Pausando canción...");
        reproductor.pausar();

        // Esperar un poco más para asegurarnos de que la pausa funcionó
        try {
            Thread.sleep(2000); // 2000 milisegundos = 2 segundos
        } catch (InterruptedException e) {
            System.out.println("La espera fue interrumpida: " + e.getMessage());
        }
        // Pausar la canción
        System.out.println("Reproduciendo de nuevo la canción...");
        reproductor.reproducir();
        System.out.println("Prueba completada.");
    }
}
