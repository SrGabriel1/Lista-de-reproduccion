
import entidades.ListaReproduccion;
import java.util.logging.Level;
import java.util.logging.Logger;
import listamusicalnegocio.ListaReproduccionBO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author abelc
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          ListaReproduccionBO li=new ListaReproduccionBO();
        ListaReproduccion l=new ListaReproduccion();
        l.setNombreLista("ua");
        try {
            li.crearListaReproduccion(l);
            System.out.println("lista creada");
            System.out.println(li.BuscarLista("ua"));
        } catch (Exception ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
