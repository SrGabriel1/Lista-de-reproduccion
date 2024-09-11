/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import entidades.ListaReproduccion;
import interfaz.frmCanciones;
import interfaz.frmListas;
import interfaz.frmNuevaLista;
import interfaz.frmPlaylist;
import interfaz.frmPrincipal;
import listamusicalnegocio.ListaReproduccionBO;

/**
 *
 * @author abelc
 */
public class ControlListaReproduccion {

    private static ControlListaReproduccion instancia;
    private ListaReproduccion listaRep; 
    private ListaReproduccionBO listaBO;
     
    public ControlListaReproduccion() {
    }

    public static ControlListaReproduccion getInstancia() {
        if (instancia == null) {
            instancia = new ControlListaReproduccion();
        }
        return instancia;

    }

    public ListaReproduccion getListaRep() {
       
        if (listaRep == null) {
          
            listaRep = new ListaReproduccion();
        }
   
        return listaRep;
    }

    public void setListaRep(ListaReproduccion listaRep) {
        this.listaRep = listaRep;
    }

    public void mostrarMenu(){
    frmPrincipal menu=new frmPrincipal();
    menu.setVisible(true);
    }
    
    public void mostrarPlaylist(){
    frmPlaylist playlist=new frmPlaylist();
    playlist.setVisible(true);
    }
    
    public void mostrarFrmListas(){
    frmListas listas=new frmListas();
    listas.setVisible(true);
    }
    
    public void mostrarFrmCanciones(){
    frmCanciones canciones=new frmCanciones();
    canciones.setVisible(true);
    }
    
    public void mostrarFrmNuevaLista() {
        frmNuevaLista frmNuevaLista = new frmNuevaLista();
        frmNuevaLista.setVisible(true);
    }

    public ListaReproduccionBO getListaBO() {
        if (listaBO==null) {
            listaBO=new ListaReproduccionBO();
        }
        return listaBO;
    }

    public void setListaBO(ListaReproduccionBO listaBO) {
        this.listaBO = listaBO;
    }
    
}
