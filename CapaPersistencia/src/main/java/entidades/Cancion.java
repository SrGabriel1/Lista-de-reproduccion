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
    private Artista artista;
    private int duracion;
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
    public Cancion(String nombreCancion, Artista artista, int duracion, String direccion) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.duracion = duracion;
        this.direccion = direccion;
    }

    /**
     * Metodo para mostrar el artista
     *
     * @return regresa el artista deseado
     */
    public Artista getArtista() {
        return artista;
    }

    /**
     * Metodo que guarda el artista
     *
     * @param artista artista que se desea guardar
     */
    public void setArtista(Artista artista) {
        this.artista = artista;
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
     * Método para obtener la duración en segundos
     *
     * @return duración en segundos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Método para guardar la duración en segundos
     *
     * @param duracion duración en segundos
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
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

    /**
     * Método que retorna la duración formateada en minutos y segundos
     *
     * @return duración formateada en formato mm:ss
     */
    public String getDuracionFormateada() {
        int minutos = duracion / 60;
        int segundos = duracion % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

}
