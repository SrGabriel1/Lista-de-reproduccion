/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Cancion {

    private String nombreCancion;
    private String direccion;

    /**
     * Constructor donde se inicializan las variables de la clase
     *
     * @param nombreCancion nombre de la canción
     * @param artista artista que creó la canción
     * @param duracion segundos de la duración de la canción
     * @param direccion representa la direccion donde se encuentra el archivo de
     * la cancion
     */
    public Cancion(String nombreCancion,  String direccion) {
        this.nombreCancion = nombreCancion;
        this.direccion = direccion;
    }

 


    /**
     * Metodo para el nombre de la cancion
     *
     * @return cancion que se desea mostrar
     */
    public String getNombreCancion() {
        return nombreCancion;
    }

    /**
     * Metodo que guarda el nombre de la cancion
     *
     * @param nombreCancion
     */
    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    /**
     * Método para obtener la dirección del archivo
     *
     * @return diracción del archivo de la canción
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Método para guardar la direccion en la cual se encuentra el archivo
     *
     * @param direccion direccion del archivo
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
