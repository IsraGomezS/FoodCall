/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.StringTokenizer;
import proyectofinal.modelo.Platillo;

/**
 * Classe para el manejo de archivos csv
 * @author alanm
 */
public class BaseDeDatos {
    private String nombre;
    private int numColumnas;
    /**
     * Metodo constructor vacio
     */
    public BaseDeDatos() {
    }
    /**
     * Metodo constructor que inicializa variables
     * @param nombre nombre del archivo
     * @param numColumnas numero de parametros que se van a meter
     */
    public BaseDeDatos(String nombre, int numColumnas) {
        this.nombre = nombre;
        this.numColumnas = numColumnas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }
    /**
     * Este metodo crea el archivo si no existe
     */
    public void creearBaseDeDatos(){
        FileWriter archivo=null;
        try {
            archivo = new FileWriter(nombre+".csv");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    /**
     * Metodo que obtiene toda la base de datos
     * @return retorna un arrayList de Strings con toda la base de datos
     */
    public ArrayList <String> obtenerBD(){
        ArrayList <String> tabla=new ArrayList<>();
        try {
            String fila;
            FileReader fr = null;
            fr = new FileReader(nombre+".csv");
            BufferedReader br=new BufferedReader(fr);
            fila = br.readLine();
            if (fila==null) {
                System.out.println("Vacia");
            } else {
                while(fila!=null){
                    tabla.add(fila);
                    fila = br.readLine();
                }
            }                
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }catch (IOException ex) {
            java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return tabla;
    }
    /**
     * Metodo que agrega una fila en la base de datos y la guarda en el archivo
     * @param objeto resive un objeto pero modificado en el toString con comas
     */
    public void agregar(Object objeto){
       try {
            ArrayList <String> tabla=new ArrayList<String>();
            ArrayList <String> tablaAux=new ArrayList<String>();
            tablaAux.addAll(obtenerBD());
            int i=0;
            for (int j = 0; j < tablaAux.size(); j++) {
                tabla.add(tablaAux.get(j));
            }
            FileWriter fw = new FileWriter(nombre+".csv");//Crea un archivo con nombre
            BufferedWriter bw= new BufferedWriter(fw);//Inicializa el buffer
            PrintWriter salida = new PrintWriter(bw);//Inicializa la comunicacion con el buffer
            if(tabla.size()!=0){
                for (i= 0; i < tabla.size(); i++){
                   salida.println(tabla.get(i));
                }
            }
            if(tabla.size()==0) {
               salida.print(objeto);
            } else {
               salida.println(objeto);//imprime lo que tu quieras
            }
            salida.close();//cierra el archivo
        } catch (IOException ex) {
            System.out.println("Error en base de datos");
        }
    }
    /**
     * Metodo que elimina una fila
     * @param id es el indicador de la fila que se desea eliminar
     */
    public void eliminar(int id){
       ArrayList <String> tabla=new ArrayList<String>();
       String linea=null;
       tabla.addAll(obtenerBD());
       tabla.remove(dameElNumeroLaFila(id));
       FileWriter fw;
        try {
            fw = new FileWriter(nombre+".csv"); //Crea un archivo con nombre
            BufferedWriter bw= new BufferedWriter(fw);//Inicializa el buffer
            PrintWriter salida = new PrintWriter(bw);//Inicializa la comunicacion con el buffer
            if(tabla.size()!=0){
                for (int i= 0; i < tabla.size(); i++){
                   salida.println(tabla.get(i));
                }
            }
            if(tabla.size()==0) {
                System.out.println("Vacia no hay que borrar");
            }
            salida.close();//cierra el archivo
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    /**
     * Da el numero para el arrayList con el indicador
     * @param id indicador de fila
     * @return un valor entero que te da la fila del arreglo
     */
    public int dameElNumeroLaFila(int id){
        int fila=-1,bandera=0;
        String linea=null;
        ArrayList <String> tabla=new ArrayList<String>();
        StringTokenizer token;
        tabla.addAll(obtenerBD());
        String dato=null;
    //Obtener fila del id
           for (int i = 0; 1!=bandera && i<tabla.size(); i++) {
               linea=tabla.get(i);
               token=new StringTokenizer(linea,",");
               dato=token.nextToken();
               if (parseInt(dato)==id) {
                   fila=i;
                   bandera=1;
               }
           }
        return fila;
    }
    public void agregarBaseDeDatosCompleta(ArrayList <Object> tabla){
        for (int i = 0; i < tabla.size(); i++) {
            agregar(tabla.get(i));
        }
    }
    /**
     * Da la fila completa en String
     * @param id identificador de la fila
     * @return retorna un String de la fila completa
     */
    public String dameLaFila(int id){
        int fila=dameElNumeroLaFila(id);
        String linea=null;
        ArrayList <String> tabla=new ArrayList<String>();
        StringTokenizer token;
        tabla.addAll(obtenerBD());
    //Obtener fila del id
        linea=tabla.get(fila);
        return linea;
    }
    /**
     * Modifica una fila completa
     * @param id identificador de la fila
     * @param datosNuevos objeto modificado en toString con comas
     */
    public void modificarFila(int id, Object datosNuevos){
        FileWriter fw=null;
        ArrayList <String> tabla=new ArrayList<String>();
        String dat=null;
        dat=datosNuevos.toString();
        try {
            int fila=dameElNumeroLaFila(id);
            tabla.addAll(obtenerBD());
            tabla.set(fila, dat);
            fw = new FileWriter(nombre+".csv"); //Crea un archivo con nombre
            BufferedWriter bw= new BufferedWriter(fw);//Inicializa el buffer
            PrintWriter salida = new PrintWriter(bw);//Inicializa la comunicacion con el buffer
            for (int i= 0; i < tabla.size(); i++){
                salida.println(tabla.get(i));
            }
            salida.close();//cierra el archivo
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
   /*public void modificarUnDato(int id, int datoDeseado, String nuevoDato){
        FileWriter fw=null;
        ArrayList <String> tabla=new ArrayList<String>();
        try {
            int fila=dameElNumeroLaFila(id),j=0;
            tabla.addAll(obtenerBD());
            fw = new FileWriter(nombre+".csv"); //Crea un archivo con nombre
            BufferedWriter bw= new BufferedWriter(fw);//Inicializa el buffer
            PrintWriter salida = new PrintWriter(bw);//Inicializa la comunicacion con el buffer
            for (int i= 0; i < tabla.size(); i++){
                if(i!=fila){
                    salida.println(tabla.get(i));
                }
                else{
                    while (j<numColumnas) {
                        if (j!=datoDeseado-1) {
                            salida.print(busquedaDeUnDato(fila,j)+",");   
                        } else {
                            salida.print(nuevoDato+",");
                        }
                    }
                }
                    
            }
            salida.close();//cierra el archivo
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(BaseDeDatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }*/
    /**
     * Te da un dato que deseas buscar en la base de datos
     * @param id identificador de la fila
     * @param datoDeseado numero de la columna
     * @return retorna un String del dato que quieres
     */
    public String busquedaDeUnDato(int id,int datoDeseado){
       ArrayList <String> tabla=new ArrayList<String>();
       String linea=null;
       StringTokenizer token;
       tabla.addAll(obtenerBD());
       String dato=null;
        if(tabla!=null){
           int columna,fila,j=0;
            if (dameElNumeroLaFila(id)!=-1){
                for (int i = 0; i <= dameElNumeroLaFila(id);i++) {
                    columna=datoDeseado-1;
                    j=0;
                    linea=tabla.get(i);
                    token=new StringTokenizer(linea,",");
                    while (j<=columna&&token.hasMoreTokens()) {
                        dato=token.nextToken();
                        j++;
                    }
                    if (j<datoDeseado) {
                        dato=null;
                    }
                }
            } else {
                dato=null;
            } 
        }
       return dato;
    }
    
}
