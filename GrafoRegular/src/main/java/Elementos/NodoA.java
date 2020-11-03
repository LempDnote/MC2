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
public class NodoA {
    TDAA grafos;
    NodoA siguiente = null;

    public NodoA(TDAA grafos) {
        this.grafos = grafos;
    }

    public NodoA getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoA siguiente) {
        this.siguiente = siguiente;
    }
    
}
