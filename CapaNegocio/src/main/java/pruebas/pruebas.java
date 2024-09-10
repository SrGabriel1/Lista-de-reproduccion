/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import daos.CancionDAO;
import entidades.Cancion;
import java.util.Arrays;
import java.util.List;
import listamusicalnegocio.ReproductorBO;

/**
 *
 * @author Gabriel
 */
public class pruebas {

    public static void main(String[] args) {
        // Crear algunas canciones de ejemplo
        CancionDAO cancion = new CancionDAO();
   
        List<Cancion> listaCanciones = cancion.obtenerCanciones();
//        for (Cancion c : cancion.obtenerCanciones()) {
//            System.out.println(c.getNombreCancion());
//            System.out.println(c.getDireccion());
//        }
        // Crear el reproductor
        ReproductorBO reproductor = new ReproductorBO(listaCanciones);

//         Reproducir la primera canción
        reproductor.reproducir();

        // Pausar la canción
        // reproductor.pausar();
        // Reproducir la siguiente canción
        // reproductor.siguiente();
        // Reproducir la anterior canción
        // reproductor.anterior();
    }
}
