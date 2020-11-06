
package Elementos;

import javax.swing.JOptionPane;

public class Solucion {
    private ListaA aux;
    String cadena;
    
    public Solucion(ListaA aux,String cadena) {
        this.aux =  aux; 
        this.cadena = cadena;
        
    }
    public void Cadena(){
        String orden [] = cadena.split("-");
        for (int i = 0; i < orden.length-1; i++) {
            aux.Buscar(Integer.parseInt(orden[i]),Integer.parseInt(orden[i+1]));
        }
        if(aux.Estado() == false){
            JOptionPane.showMessageDialog(null,"No es un circuito Eurliano");
            
        }else{
            JOptionPane.showMessageDialog(null,"Si es un circuito Eurliano \n Felicidades");
        }
    }
    public String BuscarSolucion(){
        int vertices[][] = this.aux.Grafos();
        String cadena = "";
        for (int fila = 0; fila < vertices.length; fila++) {
            if(fila == 0){
                cadena += Integer.toString(vertices[fila][0])+"-"+Integer.toString(vertices[fila][1])+"-";
            }
            if(fila > 0 && fila < vertices.length-1){
                cadena += Integer.toString(vertices[fila][1])+"-";
            }
            if(fila == vertices.length-1){
                cadena += Integer.toString(vertices[fila][1]);
            }
        }
        
        for (int fila = 0; fila < vertices.length; fila++) {
            for (int columna = 0; columna < vertices[fila].length; columna++) {
                System.out.print(vertices[fila][columna]);
            }
            System.out.println("");
        }
        return cadena;
    }
    
}
