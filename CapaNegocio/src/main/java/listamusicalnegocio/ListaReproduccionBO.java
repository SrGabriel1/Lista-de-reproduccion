/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listamusicalnegocio;

import daos.ListaReproduccionDAO;
import entidades.Cancion;
import entidades.ListaReproduccion;
import java.util.List;
import listamusicalnegocio.CancionBO;
import listamusicalnegocio.IListaReproduccionBO;

/**
 *
 * @author abelc
 */
public class ListaReproduccionBO implements IListaReproduccionBO {

    ListaReproduccionDAO lista;

    /**
     * Constructor que inicializa la lista de reproduccion
     *
     * @param lista La lista con la que se va a inicializar
     */
    public ListaReproduccionBO(ListaReproduccionDAO lista) {
        this.lista = lista;
    }

    public ListaReproduccion BuscarLista(String nombreLista) throws Exception {
        ListaReproduccion lista1 = null;
        if (nombreLista != null) {
            for (int i = 0; i < lista.consultarListasRep().size(); i++) {
                if (lista.consultarListasRep().get(i).getNombreLista().equals(nombreLista)) {
                    lista1 = lista.consultarListasRep().get(i);
                }
            }
            return lista1;
        } else {
            return null;
        }
    }

    /**
     * Agrega una canción a una lista de reproducción existente.
     *
     * @param cancion La canción a agregar a la lista.
     * @param nombreLista La lista donde se va a agregar la cancion
     * @return ListaReproduccion La lista de reproducción con la nueva canción
     * agregada.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    @Override
    public ListaReproduccion agregarCancion(CancionBO cancion, String nombreLista) throws Exception {
        if (cancion != null && nombreLista != null) {
            Cancion cancion1 = cancion.ConvertirBOaNormal(cancion.getNombreCancion(), cancion.getDireccion());
            lista.agregarCancion(cancion1, nombreLista);
            return BuscarLista(nombreLista);
        } else {
            throw new Exception(nombreLista);
        }

    }

    /**
     * Consulta todas las canciones en una lista de reproducción.
     *
     * @param nombreLista La lista de reproducción sobre la cual se consultarán
     * las canciones.
     * @return List<CancionBo> Una lista con todas las canciones de la lista de
     * reproducción.
     */
    @Override
    public List<Cancion> consultarCanciones(String nombreLista) throws Exception {
        ListaReproduccion lista1 = BuscarLista(nombreLista);
        if (lista1 != null) {
            List<Cancion> cancionesGuardadas = null;
            for (Cancion cancion : lista1.getListaMusica()) {
                cancionesGuardadas.add(cancion);
            }
            return cancionesGuardadas;
        } else {
            throw new Exception(nombreLista);
        }

    }

   /**
     * Elimina una canción de una lista de reproducción.
     *
     * @param nombreLista La lista de donde se quiere eliminar la cancion
     * @param cancion La canción a eliminar de la lista.
     * @return ListaReproduccion La lista de reproducción sin la canción
     * eliminada.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    @Override
    public ListaReproduccion eliminarCancion(String nombreLista, Cancion cancion) throws Exception {
        if (cancion != null && nombreLista != null) {
            lista.eliminarCancion(nombreLista, cancion);
            return BuscarLista(nombreLista);
        } else {
            throw new Exception(nombreLista);
        }
    }

    /**
     * Crea una nueva lista de reproducción vacía.
     *
     * @param listaCreada Lalista que se va aguardar en el sistema
     *
     * @return ListaReproduccion la nueva lista de reproducción creada.
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    @Override
    public ListaReproduccion crearListaReproduccion(ListaReproduccion listaCreada) throws Exception {
        ListaReproduccion lista1 = null;
        if (listaCreada != null) {
            if (BuscarLista(listaCreada.getNombreLista()) == null) {
                lista1 = lista.crearListaReproduccion(listaCreada);
            }
            return lista1;
        } else {
            throw new Exception("Ya existe una lista con ese nombre");
        }
    }

    /**
     * consulta todas las listas de reproduccion creadas
     *
     * @return listas de reproduccion
     * @throws java.lang.Exception Tira una excepcion si algo esta mal con el
     * codigo
     */
    @Override
    public List<ListaReproduccion> consultarListasRep() throws Exception {
        if (lista.consultarListasRep() != null) {
            return lista.consultarListasRep();
        } else {
            throw new Exception("No tienes listas de reproduccion");
        }
    }

}
