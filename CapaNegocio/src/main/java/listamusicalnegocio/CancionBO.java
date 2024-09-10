/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listamusicalnegocio;

import daos.CancionDAO;
import entidades.Cancion;
import java.util.List;

/**
 *
 * @author abelc
 */
public class CancionBO implements ICancionBO {

    CancionDAO cancion;
    private String nombreCancion;
    private String direccion;

    /**
     * Constructor para incializar cancionDao
     *
     * @param cancion valores para iniciar la variable
     */
    public CancionBO(CancionDAO cancion) {
        this.cancion = cancion;
    }

    /**
     * Constructor vacio para incializar la clase
     */
    public CancionBO() {
    }

    /**
     * Constructor donde se inicializan las variables de la clase
     *
     * @param nombreCancion nombre de la canción
     * @param direccion representa la direccion donde se encuentra el archivo de
     * la cancion
     */
    public CancionBO(String nombreCancion, String direccion) {
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

    /**
     * Metodo que busca una cancion por medio de su nombre o las parecidas
     *
     * @param nombre El nombre de la cancion que se busca
     * @return La cancion si esta en la lista o existe una parecida
     * @throws Exception Tira una excepcion si en la lista no esta o se escribio
     * mal el nombre de la cancion
     */
    @Override
    public List<Cancion> buscarCancion(String nombre) throws Exception {
        if (nombre != null) {
            return cancion.buscarCancion(nombre);
        } else {
            throw new Exception("Nombre invalido/No esta en lista");
        }
    }

    /**
     * Metodo que busca una cancion en especifico
     *
     * @param nombre nombre de la cancion
     * @return La cancion encontrada
     * @throws Exception Tira una excepcion si en la lista no esta o se escribio
     * mal el nombre de la cancion
     */
    @Override
    public Cancion encontrarCancion(String nombre) throws Exception {
        if (nombre != null) {
            return cancion.encontrarCancion(nombre);
        } else {
            throw new Exception("Nombre invalido/No esta en lista");
        }
    }

    /**
     * Metodo que muestra la lista completa de las canciones
     *
     * @return Todas las canciones que estan en la lista
     * @throws Exception Tira una excepcion si la lista esta vacia
     */
    @Override
    public List<Cancion> obtenerCanciones() throws Exception {
        if (cancion.obtenerCanciones() != null) {
            return cancion.obtenerCanciones();
        } else {
            throw new Exception("Lista de canciones vacia");
        }
    }

    /**
     * Metodo que pasa los datos de formato BO a normal para que se puedan
     * guardar
     *
     * @param nombre nombre de la canción
     * @param direccion representa la direccion donde se encuentra el archivo de
     * la cancion
     * @return regresa una cancion normal con los datos convertidos
     */
    @Override
    public Cancion ConvertirBOaNormal(String nombre, String direccion) {
        if (nombre != null && direccion != null) {
            return new Cancion(nombreCancion, direccion);
        } else {
            return null;
        }
    }

}
