/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author Gabriel
 */
public class Artista {

    private String nombre;
    private List<Cancion> listaMusica;

    /**
     * Metodo que crea una variable de nombre del artista
     *
     * @param nombre
     */
    public Artista(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo constructor vacio
     */
    public Artista() {

    }

    /**
     * Metodo que regresa el nombre del artista
     *
     * @return regra el nombre del artista seleccionado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que guarda el nombre del artista
     *
     * @param nombre nombre del artista que se va guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Lista de musica perteneciente a un artista
     *
     * @return lista de musica del artista
     */
    public List<Cancion> getListaMusica() {
        return listaMusica;
    }

    /**
     * Metodo para guardar una lista de musica
     *
     * @param listaMusica lista de musica que se desea guardar
     */
    public void setListaMusica(List<Cancion> listaMusica) {
        this.listaMusica = listaMusica;
    }

}
