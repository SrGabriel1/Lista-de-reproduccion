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
    private String username;
    private String contraseña;

    /**
     * Constructor donde se inicializan las variables de la clase
     *
     */
    public Usuario() {
        this.listaReproduccion = new ArrayList<>();
    }

    /**
     * Constructor donde se inicializan las variables de la clase
     *
     * @param username nombre de usuario
     * @param contraseña contraseña del usuario
     */
    public Usuario(String username, String contraseña) {
        this.username = username;
        this.contraseña = contraseña;
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

    /**
     * Método para obtener el nombre de usuario
     *
     * @return nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método para establecer el nombre de usuario
     *
     * @param username nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método para obtener la contraseña del usuario
     *
     * @return contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Método para establecer la contraseña del usuario
     *
     * @param contraseña contraseña del usuario
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
