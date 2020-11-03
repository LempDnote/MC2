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
public class Temporal {
    Nodo cabeza;
    public Temporal(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    public int Grado(){
        Nodo aux = this.cabeza;
        int grado = 0;
        while(aux != null){
            if(aux.datos.getGrado() > grado){
//                System.out.println("______________________");
//                System.out.println(aux.datos.getNumero());
//                System.out.println(aux.datos.getGrado());
//                System.out.println("_______________________");
                grado = aux.datos.getGrado();
            }    
            aux = aux.getSiguiente();
        }
        return grado;
    }
}
