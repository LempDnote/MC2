package Elementos;
import Ventanas.Principal;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        if(this.aristas > 1){
            
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
         }else if(this.aristas == 1){
            int inicial = 1;
            for (int i = 1; i <= this.vertices; i++) {
                if(i == this.vertices){
                    this.listaa.Ingresar(new TDAA(i,1));
                }else{
                    this.listaa.Ingresar(new TDAA(i,i+1));
                }
                
            }
         }
        Fichero();
        EjecutarDot();
//        try{
//            Thread.sleep(1000);
//        }catch(Exception e){
//            System.out.println(e);
//        }
        
        
    }
    private String cadena(){
        String cadena = "";
        cadena += this.lista.Cadena();
        cadena += this.listaa.Cadena();
        return cadena;
    }
    private void Fichero(){
        try{
            PrintWriter pw = new PrintWriter("C:/Users/Eduardo/Desktop/MC2/Grafo/grafo.txt","UTF-8");
            pw.write(cadena());
            pw.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private void EjecutarDot(){
        try{
            String cmd [] = new String[5];
            cmd[0] = "C:/Program Files (x86)/Graphviz2.38/bin/dot.exe";
            cmd[1] = "-Tpng";
            cmd[2] = "C:/Users/Eduardo/Desktop/MC2/Grafo/grafo.txt";
            cmd[3] = "-o";
            cmd[4] = "C:/Users/Eduardo/Desktop/MC2/Grafo/grafo.png";
            Process child = Runtime.getRuntime().exec(cmd);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private String cadena2(){
        String cadena2 = "";
        cadena2 += "C:/Users/Eduardo/Desktop/MC2/Grafo\n";
        cadena2 += "dot -Tpng grafo.txt -o grafo.png";
        return cadena2;
    }

    public ListaA getListaa() {
        return listaa;
    }

    public void setListaa(ListaA listaa) {
        this.listaa = listaa;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
    
   
}
