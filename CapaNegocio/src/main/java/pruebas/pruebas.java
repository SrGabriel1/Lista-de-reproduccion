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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
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
        CancionDAO cancionDAO = new CancionDAO();
        List<Cancion> listaCanciones = cancionDAO.obtenerCanciones();
        ReproductorBO reproductor = new ReproductorBO(listaCanciones);

        // Reproducir la canción actual
        System.out.println("Reproduciendo canción...");
        reproductor.reproducir();
        reproductor.siguiente();

        // Usar CompletableFuture para manejar las esperas y acciones
        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Pausando canción...");
                reproductor.pausar();

                TimeUnit.SECONDS.sleep(2);
                System.out.println("Reproduciendo de nuevo la canción...");
                reproductor.reproducir();

                System.out.println("Prueba completada.");
            } catch (InterruptedException e) {
                System.out.println("La operación fue interrumpida: " + e.getMessage());
            } catch (JavaLayerException ex) {
                Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).join();
    }
}
