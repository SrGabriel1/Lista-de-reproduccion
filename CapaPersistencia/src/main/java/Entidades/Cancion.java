/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Cancion {

    String nombreCancion;
    Artista artista;
    
    List<String> direccion;

    /**
     * Constructor donde se inicializan las variables de la clase
     *
     * @param nombreCancion nombre de la cancion
     * @param artista artista que creo la cancion
     */
    public Cancion(String nombreCancion, Artista artista) {
        this.nombreCancion = nombreCancion;
        this.artista = artista;
        this.direccion = new ArrayList<>(); 

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
     * Metodo para obtener una lista con la direccion de las canciones guardadas
     *
     * @return lista con la direccion de las canciones
     */
    public List<String> getListaLink() {
        return direccion;
    }

    /**
     * Metodo para guardar la direccion de una cancion
     *
     * @param direccion direccion de la cancion
     */
    public void setListaLink(String direccion) {
        this.direccion.add(direccion);
    }

}
