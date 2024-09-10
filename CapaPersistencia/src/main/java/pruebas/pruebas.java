/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import daos.CancionDAO;
import entidades.Cancion;

/**
 *
 * @author abelc
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CancionDAO c=new CancionDAO();
       
        for (Cancion cancion: c.obtenerCanciones()) {
            System.out.println(cancion.getNombreCancion());
            System.out.println(cancion.getDireccion());
        }
    }
    
}
