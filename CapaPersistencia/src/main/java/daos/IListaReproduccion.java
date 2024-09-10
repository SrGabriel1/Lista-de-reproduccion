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
     * @param nombreLista
     * @return ListaReproduccion La lista de reproducción con la nueva canción
     * agregada.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    public ListaReproduccion agregarCancion(Cancion cancion,String nombreLista)throws Exception;

    /**
     * Consulta todas las canciones en una lista de reproducción.
     *
     * @param nombreLista La lista donde se va a buscar la cancion requerida
     * @param listaRep La lista de reproducción sobre la cual se consultarán las
     * canciones.
     * @return List<Cancion> Una lista con todas las canciones de la lista de
     * reproducción.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    public List<Cancion> consultarCanciones(String nombreLista)throws Exception;

    /**
     * Elimina una canción de una lista de reproducción.
     *
     * @param nombreLista La lista donde se va a eliminar la cancion
     * @param cancion La canción a eliminar de la lista.
     * @return ListaReproduccion La lista de reproducción sin la canción
     * eliminada.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    public ListaReproduccion eliminarCancion(String nombreLista, Cancion cancion)throws Exception;

   
    /**
     * Crea una nueva lista de reproducción vacía.
     *
     * @param listaCreada La lista que se quiere guardar
     * @return ListaReproduccion la nueva lista de reproducción creada.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    public ListaReproduccion crearListaReproduccion( ListaReproduccion listaCreada)throws Exception;
    
    /**
     * consulta todas las listas de reproduccion creadas
     * @return listas de reproduccion
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    public List<ListaReproduccion> consultarListasRep()throws Exception;
}
