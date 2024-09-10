/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Cancion;
import entidades.ListaReproduccion;
import java.util.List;

/**
 * Interface que define las operaciones básicas de una lista de reproducción.
 *
 * @author abelc
 */
public interface IListaReproduccion {

    /**
     * Agrega una canción a una lista de reproducción existente.
     *
     * @param cancion La canción a agregar a la lista.
     * @return ListaReproduccion La lista de reproducción con la nueva canción
     * agregada.
     */
    public ListaReproduccion agregarCancion(Cancion cancion,String nombreLista);

    /**
     * Consulta todas las canciones en una lista de reproducción.
     *
     * @param listaRep La lista de reproducción sobre la cual se consultarán las
     * canciones.
     * @return List<Cancion> Una lista con todas las canciones de la lista de
     * reproducción.
     */
    public List<Cancion> consultarCanciones(String nombreLista);

    /**
     * Elimina una canción de una lista de reproducción.
     *
     * @param cancion La canción a eliminar de la lista.
     * @return ListaReproduccion La lista de reproducción sin la canción
     * eliminada.
     */
    public ListaReproduccion eliminarCancion(String nombreLista, Cancion cancion);

   
    /**
     * Crea una nueva lista de reproducción vacía.
     *
     * @return ListaReproduccion la nueva lista de reproducción creada.
     */
    public ListaReproduccion crearListaReproduccion( ListaReproduccion listaCreada);
    
    /**
     * consulta todas las listas de reproduccion creadas
     * @return listas de reproduccion
     */
    public List<ListaReproduccion> consultarListasRep();
}
