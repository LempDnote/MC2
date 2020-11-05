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
public class TDAA {
    public int Grafo1;
    public int Grafo2;
    private boolean estado = true;
    public TDAA(int Grafo1, int Grafo2) {
        this.Grafo1 = Grafo1;
        this.Grafo2 = Grafo2;
    }

    public int getGrafo1() {
        return Grafo1;
    }

    public void setGrafo1(int Grafo1) {
        this.Grafo1 = Grafo1;
    }

    public int getGrafo2() {
        return Grafo2;
    }

    public void setGrafo2(int Grafo2) {
        this.Grafo2 = Grafo2;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
