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
                estado = false;
            }
            aux = aux.getSiguiente();
        }
        return estado;
    }
    public void Buscar(int g1, int g2){
        NodoA aux = this.cabeza;
        while(aux != null){
            if(aux.grafos.isEstado()){
                if((aux.grafos.Grafo1 == g1 && aux.grafos.Grafo2 == g2) | (aux.grafos.Grafo1 == g2 &&
                    aux.grafos.Grafo2 == g1)){
                aux.grafos.setEstado(false);
                break;
            }
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
    public int [][] Grafos(){
        NodoA aux = this.cabeza;
        int tamaño = 0;
        while(aux != null){
            tamaño++;
            aux = aux.getSiguiente();
        }
        int matriz [][] = new int[tamaño][2];
        matriz[0][0] = this.cabeza.grafos.Grafo1;
        matriz[0][1] = this.cabeza.grafos.Grafo2;
        this.cabeza.grafos.setEstado(false);
        NodoA aux2 = this.cabeza;
        while(aux2 != null){
            if(aux2.grafos.isEstado() == true){
                if(aux2.grafos.Grafo1 == this.cabeza.grafos.Grafo1){
                matriz[tamaño-1][0] = aux2.grafos.Grafo2;
                matriz[tamaño-1][1] = aux2.grafos.Grafo1;
                aux2.grafos.setEstado(false);
                break;
                }
                if(aux2.grafos.Grafo2 == this.cabeza.grafos.Grafo1){
                matriz[tamaño-1][0] = aux2.grafos.Grafo1;
                matriz[tamaño-1][1] = aux2.grafos.Grafo2;
                aux2.grafos.setEstado(false);
                break;
                }  
            }
            aux2 = aux2.getSiguiente();
        }
        
        for (int fila = 1; fila <= matriz.length-1; fila++) {
            if(matriz[fila][0] == 0){
                int grafo = matriz[fila-1][1];
                NodoA aux3 = this.cabeza;
                while(aux3 != null){
                    if(aux3.grafos.isEstado() == true){
                        if(aux3.grafos.Grafo1 == grafo){
                            matriz[fila][0] = aux3.grafos.Grafo1;
                            matriz[fila][1] = aux3.grafos.Grafo2;
                            aux3.grafos.setEstado(false);
                            break;
                        }else if(aux3.grafos.Grafo2 == grafo){
                            matriz[fila][0] = aux3.grafos.Grafo2;
                            matriz[fila][1] = aux3.grafos.Grafo1;
                            aux3.grafos.setEstado(false);
                            break;
                        }
                        
                    }
                    aux3 = aux3.siguiente;
                }
            }
        }
        return matriz;
    }
    public void Limpiar(){
        NodoA aux = this.cabeza;
        while(aux != null){
            aux.grafos.setEstado(true);
            aux = aux.getSiguiente();
        }
    }
}
