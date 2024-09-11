/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidades.Cancion;
import entidades.ListaReproduccion;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author abelc
 */
public class ListaReproduccionDAO implements IListaReproduccion {

    private List<ListaReproduccion> listasDeReproduccion;

    public ListaReproduccionDAO() {
        listasDeReproduccion = new ArrayList<>();
            
    }
    
    

    /**
     * {@inheritDoc}
     */
    @Override
    public ListaReproduccion agregarCancion(Cancion cancion, String nombreLista) {
        for (ListaReproduccion lista : listasDeReproduccion) {
            if (lista.getNombreLista().equals(nombreLista)) {
                lista.getListaMusica().add(cancion);
                return lista;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cancion> consultarCanciones(String nombreLista) {
        for (ListaReproduccion lista : listasDeReproduccion) {
            if (lista.getNombreLista().equals(nombreLista)) {
                return lista.getListaMusica();
            }
        }
        return new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListaReproduccion eliminarCancion(String nombreLista, Cancion cancion) {
        for (ListaReproduccion lista : listasDeReproduccion) {
            if (lista.getNombreLista().equals(nombreLista)) {
                if (lista.getListaMusica().remove(cancion)) {
                    return lista;
                } else {

                    return null;
                }
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ListaReproduccion crearListaReproduccion(ListaReproduccion listaCreada) {
        listasDeReproduccion.add(listaCreada);
        return listaCreada;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ListaReproduccion> consultarListasRep() {
        return listasDeReproduccion;
    }

}
