
package Elementos;

public class Solucion {
    private ListaA aux;
    String cadena;
    
    public Solucion(ListaA aux,String cadena) {
        this.aux =  aux; 
        this.cadena = cadena;
        Cadena();
    }
    private void Cadena(){
        String orden [] = cadena.split("->");
        for (int i = 0; i < orden.length-1; i++) {
            aux.Buscar(Integer.parseInt(orden[i]),Integer.parseInt(orden[i+1]));
        }
        if(aux.Estado() == false){
            System.out.println("verga");
        }else{
            System.out.println("si es solucion");
        }
    }
    
    
}
