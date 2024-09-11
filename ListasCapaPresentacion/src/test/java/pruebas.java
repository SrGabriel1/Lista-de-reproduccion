
import daos.CancionDAO;
import entidades.Cancion;
import entidades.ListaReproduccion;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import listamusicalnegocio.ListaReproduccionBO;
import listamusicalnegocio.ReproductorBO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author abelc
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JavaLayerException, IOException {
//          ListaReproduccionBO li=new ListaReproduccionBO();
//        ListaReproduccion l=new ListaReproduccion();
//        l.setNombreLista("ua");
//        try {
//            li.crearListaReproduccion(l);
//            System.out.println("lista creada");
//            System.out.println(li.BuscarLista("ua"));
//        } catch (Exception ex) {
//            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
