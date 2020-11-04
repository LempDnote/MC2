/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;
import java.util.Random;
public class Lista {
    Nodo cabeza;

    public Lista() {
        this.cabeza = null;
    }
    public void Insertar(TDA datos){
        Nodo nuevo = new Nodo(datos);

        if(cabeza == null){
            this.cabeza = nuevo;
        }else{
            Nodo temporal = this.cabeza;
            while(temporal.getSiguiente() != null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(nuevo);
        }
    }
    public void Visualizar(){
        Nodo aux = this.cabeza;
        
        while(aux != null){
            System.out.println(aux.datos.numero);
            aux = aux.getSiguiente();
        }
                
    }
    public void Modificar(int numero,String modificacion,int valor){
        Nodo aux = this.cabeza;
        while(aux != null){
         if(aux.datos.getNumero() == numero){
             switch(modificacion){
             case "grado":
                 aux.datos.setGrado(aux.datos.getGrado()+valor);
                 break;
             case "estado":
                 aux.datos.setEstado(false);
                 break;
         }   
         }
         aux = aux.getSiguiente();
        }
    }
    public boolean Consultar(int numero,String consulta){
        Nodo aux = this.cabeza;
        boolean estado = false;
        while(aux != null){
            if(aux.datos.numero == numero){
                switch(consulta){
                case "grado":
                    if(aux.datos.getGrado() > 0){
                        estado = true;
                    }
                    break;
                case "estado":
                    if(aux.datos.isEstado()){
                        estado = true;
                    }
                    break;
            }
            }
            aux = aux.getSiguiente();
        }
        return estado;
    }
    public boolean Prioridad(int numero,int grado){
        Nodo aux = this.cabeza;
        boolean estado = false;
        int grado1 = 0;
        while(aux != null){
            if(aux.datos.getNumero() == numero){
                grado1 = aux.datos.getGrado();
            }
            aux = aux.getSiguiente();
        }
        if(grado == grado1){
            return true;
        }
        return estado;
    }
    public int Grado(){
        Nodo aux = this.cabeza;
        int grado = 0;
        while(aux != null){
            if(aux.datos.getGrado() > grado){
                grado = aux.datos.getGrado();
            }
            aux = aux.getSiguiente();
        }
        return grado;
    }
    public String Cadena(){
        String cadena = "graph neato{\n";
        cadena += "edge [style=\"solid\", color=\"blue\"];";
        Nodo aux = this.cabeza;
        while(aux != null){
            cadena += "\""+aux.datos.getNumero()+"\";\n";
            aux = aux.getSiguiente();
        }
        return cadena;
    }
}
