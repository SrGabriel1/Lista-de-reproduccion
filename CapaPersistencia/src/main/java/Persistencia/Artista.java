/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 *
 * @author Gabriel
 */
public class Artista {

String nombre;

    /**
     *Metodo que crea una variable de nombre del artista
     * @param nombre
     */
    public Artista(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Metodo que regresa el nombre del artista
     * @return regra el nombre del artista seleccionado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Metodo que guarda el nombre del artista
     * @param nombre nombre del artista que se va guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
