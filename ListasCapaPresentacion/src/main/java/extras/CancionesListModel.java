/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extras;

import entidades.Cancion;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author abelc
 */
public class CancionesListModel extends AbstractListModel<String>{
private List<Cancion> canciones;


    public CancionesListModel(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public int getSize() {
        return canciones.size(); 
    }

    @Override
    public String getElementAt(int index) {
        return canciones.get(index).getNombreCancion(); 
    }

    public void limpiarLista() {
        canciones.clear();
        fireContentsChanged(this, 0, getSize() - 1); 
    }


    public Cancion getCancionAt(int index) {
        return canciones.get(index);
    }


    public List<Cancion> getAllCanciones() {
        return canciones;
    }
  
    
}
