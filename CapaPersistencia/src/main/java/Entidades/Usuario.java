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
public class Usuario {

    private List<ListaReproduccion> listaReproduccion;

    /**
     * Constructor donde se inicializan las variables de la clase
     *
     */
    public Usuario() {
        this.listaReproduccion = new ArrayList<>();
    }

    /**
     * Metodo para mostrar las lista de reproduccion
     *
     * @return lista de reproduccion
     */
    public List<ListaReproduccion> getListaReproduccion() {
        return listaReproduccion;
    }

    /**
     * Metodo para guardar una lista de reproduccion
     *
     * @param lista lista de reproduccion que se quiere guardar
     */
    public void setListaReproduccion(ListaReproduccion lista) {
        listaReproduccion.add(lista);
    }

}
