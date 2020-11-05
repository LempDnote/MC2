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
    public boolean Estado(){
        NodoA aux = this.cabeza;
        boolean estado = true;
        while(aux != null){
            if(aux.grafos.isEstado() == true){
                System.out.println(aux.grafos.isEstado());
                estado = false;
            }
            aux = aux.getSiguiente();
        }
        return estado;
    }
    public void Buscar(int g1, int g2){
        NodoA aux = this.cabeza;
        while(aux != null){
            if((aux.grafos.Grafo1 == g1 && aux.grafos.Grafo2 == g2) || (aux.grafos.Grafo1 == g2 &&
                    aux.grafos.Grafo2 == g1)){
                aux.grafos.setEstado(false);
            }
            aux = aux.getSiguiente();
        }
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
