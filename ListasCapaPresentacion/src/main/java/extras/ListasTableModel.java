/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package extras;

import entidades.ListaReproduccion;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author abelc
 */
public class ListasTableModel extends AbstractTableModel{
    public List<ListaReproduccion> listas;
     private String[] columnNames = {"nombre:"};
      // Constructor que recibe la lista de reproducción
    public ListasTableModel(List<ListaReproduccion> listas) {
        this.listas = listas;
    }

    @Override
    public int getRowCount() {
        return listas.size(); 
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ListaReproduccion lista = listas.get(rowIndex); 
        switch (columnIndex) {
            case 0:
                return lista.getNombreLista(); 
            default:
                return null;
        }
    }

    // Método para limpiar la tabla
    public void limpiarTabla() {
        listas.clear();
        fireTableDataChanged(); 
    }

    // Método para obtener el nombre de la columna
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Método para obtener una lista específica a partir de su índice
    public ListaReproduccion getListaAt(int rowIndex) {
        return listas.get(rowIndex);
    }

    // Método para obtener todas las listas de reproducción
    public List<ListaReproduccion> getAllListas() {
        return listas;
    }
}
