/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidades.Cancion;
import java.util.List;

/**
 *
 * @author abelc
 */
public interface ICancion {
/**
     * Busca canciones cuyo nombre contenga una cadena dada.
     * La búsqueda no es sensible a mayúsculas/minúsculas.
     *
     * @param nombre El nombre o parte del nombre de la canción a buscar. 
     *               Puede ser una cadena parcial para buscar coincidencias.
     * @return Una lista de canciones que contienen la cadena de búsqueda en su nombre.
     *         Si no se encuentran coincidencias, se devuelve una lista vacía.
     */
    public List<Cancion> buscarCancion(String nombre);

    /**
     * Encuentra una canción por su nombre exacto.
     * La búsqueda no es sensible a mayúsculas/minúsculas.
     *
     * @param nombre El nombre de la canción a encontrar.
     *               Debe ser una coincidencia exacta, sin importar el caso.
     * @return La canción encontrada con el nombre dado, o {@code null} si no se encuentra ninguna canción con el nombre dado.
     */
    public Cancion encontrarCancion(String nombre);

    /**
     * Obtiene la lista de todas las canciones.
     *
     * @return Una lista de todas las canciones cargadas.
     *         La lista puede estar vacía si no se han cargado canciones.
     */
    public List<Cancion> obtenerCanciones();
}
