package Elementos;
import Ventanas.Principal;
import java.util.Random;

public class Logica {
    
    private ListaA listaa = new ListaA();
    private Lista lista = new Lista();
    private int vertices = 0;
    private int aristas = 0;
    public Logica(int vertices,int aristas){
        this.vertices = vertices;
        this.aristas = aristas;
        Grafo();
        Aristas();
    }
    private void Grafo(){
        Principal datos = new Principal(0);
        
        for (int i = 1; i <= this.vertices; i++) {
            this.lista.Insertar(new TDA(i,2*this.aristas));
        }
        
    }
    private void Aristas(){
        Random rm = new Random();
        int cAristas = this.vertices*this.aristas;
        while(cAristas > 0){
            int g1 = 1+rm.nextInt(this.vertices);
            int g2 = 1+rm.nextInt(this.vertices);
            int grado = this.lista.Grado();
            while(this.lista.Prioridad(g1,grado) == false){
                g1 = 1+rm.nextInt(this.vertices);
            }
            this.lista.Modificar(g1,"grado",-1);
            int grado2 = this.lista.Grado();
            while(this.lista.Prioridad(g2, grado2) == false){
                g2 = 1+rm.nextInt(this.vertices);
            }
            this.lista.Modificar(g2, "grado",-1);
            
            if(g1 != g2){
                this.listaa.Ingresar(new TDAA(g1,g2));
                cAristas--;
            }else{
                this.lista.Modificar(g1,"grado",+1);
                this.lista.Modificar(g2,"grado",+1);
            }
        }
        System.out.println(cadena());
    }
    private String cadena(){
        String cadena = "";
        cadena += this.lista.Cadena();
        cadena += this.listaa.Cadena();
        return cadena;
    }
    
    
}
