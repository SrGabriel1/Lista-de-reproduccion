/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import daos.CancionDAO;
import entidades.Cancion;
import entidades.ListaReproduccion;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import listamusicalnegocio.ListaReproduccionBO;
import listamusicalnegocio.ReproductorBO;

/**
 *
 * @author Gabriel
 */
public class pruebas {

    public static void main(String[] args) throws FileNotFoundException {
//        // Crear algunas canciones de ejemplo
        CancionDAO cancion = new CancionDAO();
   
        List<Cancion> listaCanciones = cancion.obtenerCanciones();
////        for (Cancion c : cancion.obtenerCanciones()) {
////            System.out.println(c.getNombreCancion());
////            System.out.println(c.getDireccion());
////        }
     ReproductorBO reproductor = new ReproductorBO(listaCanciones);

       
        reproductor.reproducir();
//       reproductor.siguiente();
//         reproductor.siguiente();
//         reproductor.siguiente();
//         Pausar la canción
//         reproductor.pausar();
        // Reproducir la siguiente canción
        // reproductor.siguiente();
        // Reproducir la anterior canción
        // reproductor.anterior();
//        ListaReproduccionBO li=new ListaReproduccionBO();
//        ListaReproduccion l=new ListaReproduccion();
//        l.setNombreLista("ua");
//           ListaReproduccion lq=new ListaReproduccion();
//        lq.setNombreLista("ud");
//        try {
//            li.crearListaReproduccion(l);
//            li.crearListaReproduccion(lq);
//          
//        } catch (Exception ex) {
//            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            for (ListaReproduccion d: li.consultarListasRep()) {
//                System.out.println(d.getNombreLista());
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
