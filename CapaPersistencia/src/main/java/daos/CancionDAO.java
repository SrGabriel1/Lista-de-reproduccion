/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import entidades.Cancion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author abelc
 */
public class CancionDAO implements ICancion {

    List<Cancion> listaCanciones;

    /**
     * Constructor vacio y que asigna las canciones de la carpeta a la lista de
     * la clase
     */
    public CancionDAO() {
        listaCanciones = new ArrayList<>();
        String rutaCarpeta = "src/main/resources/musica";
        cargarCancionesDesdeCarpeta(rutaCarpeta);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cancion> buscarCancion(String nombre) {
        List<Cancion> resultados = new ArrayList<>();
        for (Cancion cancion : listaCanciones) {
            if (cancion.getNombreCancion().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(cancion);
            }
        }
        return resultados;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cancion encontrarCancion(String nombre) {
        for (Cancion cancion : listaCanciones) {
            if (cancion.getNombreCancion().equalsIgnoreCase(nombre)) {
                return cancion;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cancion> obtenerCanciones() {
        return listaCanciones;
    }

    /**
     * Carga las canciones desde una carpeta especificada. Este método busca
     * archivos con extensión ".mp3" en el directorio dado y agrega cada archivo
     * encontrado a la lista de canciones. La ruta de la carpeta debe ser un
     * directorio válido en el sistema de archivos.
     *
     * @param rutaCarpeta La ruta del directorio que contiene los archivos MP3.
     * Debe ser una ruta absoluta o relativa al sistema de archivos.
     */
    private void cargarCancionesDesdeCarpeta(String rutaCarpeta) {
        File folder = new File(rutaCarpeta);

        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> {

                return name.toLowerCase().endsWith(".mp3");
            });

            if (files != null && files.length > 0) {
                for (File file : files) {
                    String nombreCancion = file.getName();
                    String direccion = file.getAbsolutePath();
                    Cancion cancion = new Cancion(nombreCancion, direccion);
                    listaCanciones.add(cancion);
                }
            } else {
                System.out.println("No se encontraron archivos MP3 en la carpeta.");
            }
        } else {
            System.out.println("La ruta especificada no es un directorio válido.");
        }
    }

}
