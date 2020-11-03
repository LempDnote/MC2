/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author Eduardo
 */
public class ListaA {
    
    NodoA cabeza;

    public ListaA() {
        this.cabeza = null;
    }
    
    public void Ingresar(TDAA datos){
        NodoA nuevo = new NodoA(datos);
        if(this.cabeza == null){
            this.cabeza = nuevo;
        }else{
            NodoA temporal = this.cabeza;
            while(temporal.getSiguiente() != null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevo);
        }
    }
    public void Modificar(){
        
    }
    public void Buscar(){
        
    }
    public String Cadena(){
        String cadena = "";
        NodoA aux = this.cabeza;
        while(aux != null){
            cadena += "\""+aux.grafos.Grafo1+"\""+"--"+"\""+aux.grafos.Grafo2+"\""+";\n";
            aux = aux.getSiguiente();
        }
        cadena += "}";
        return cadena;
    }
    public void Visualizar(){
        NodoA aux = this.cabeza;
        while(aux != null){
            System.out.print(aux.grafos.Grafo1+"->"+aux.grafos.Grafo2+"\n");
            aux = aux.getSiguiente();
        }
        System.out.println("****************************");
    }
    
}
