package proyectofinal.modelo;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Clase que crea a un menú.
 * @author Foodcall
 */
public class Menu {
    ArrayList <Platillo> menu = new ArrayList <> ();//LISTA QUE CONTENDRÁ LOS PLATILLOS DEL MENÚ
    /**
     * Constructor vacío.
     */
    public Menu() {
    }

    public ArrayList<Platillo> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Platillo> menu) {
        this.menu = menu;
    }
    
    /**
     * Método que crea al Menú.
     */
    public void crearMenu(){
        //1. DECLARAR A LOS PLATILLOS COMO UNA CADENA Y GUARDARLOS EN UN ARREGLO
        String [] losPlatillos = new String[10];//ARREGLO DE CADENAS, CADA CADENA ES UN PLATILLO
        String [] numerosRandom = new String [10];
        //GENERAR NÚMEROS ALEATORIOS
        for (int i = 0; i < 10; i++) {
            numerosRandom[i]=String.valueOf(crearNumRandom());
        }
        //MEXICANA
        losPlatillos[0]="1,Chapulines,200,100g Preparados con Ajo y Chile de Árbol servidos con Guacamole con quesillo y tortillas,"+numerosRandom[0];
        losPlatillos[1]="2,Tostadas de Atún Ahumado (3pzas),290,A la Mexicana Servidos con Lechuga Cremoso de Aguacate Sobre Tostada de Maíz Azul,"+numerosRandom[1];
        losPlatillos[2]="3,Pambazos de Short Rib (3pzas),265,Rellenos de Papa y Bañados en Salsa de Guajillo Acompañados de Lechuga Queso de Ocosingo y Crema,"+numerosRandom[2];
        losPlatillos[3]="4,Clásico Caldo Tlalpeño,190,De Pollo con Caldo de Jitomate Pasilla Mixe y Chipotle Arroz Blanco Vegetales Aguacate y Quesillo,"+numerosRandom[3];
        losPlatillos[4]="5,Huachinango con Mole Chichilo,260,200g con Mole Chichilo Puré de Plátano Chayote Cambray y Ejotes,"+numerosRandom[4];
        losPlatillos[5]="6,Robalo al pastor con Costra de Huitlacoche,250,Piña Tatemada Puré de Piña y Mayonesa de Ajo,"+numerosRandom[5];
        losPlatillos[6]="7,Tacos Rib Eye (3pzas),250,250g con Costra de Queso y Rajas de Chile Poblano,"+numerosRandom[6];
        losPlatillos[7]="8,Filete de Res con Costra de Pepitas de Calabaza,280,Calabaza Támala Tatemada Puré de Calabaza y Salsa de Flor de Calabaza"+numerosRandom[7];
        losPlatillos[8]="9,Buñuelo con Mousse de Quesillo,170,Con Almendras Garapiñadas y en Polvo Merengue Deshidratado y Granizado de Café de Olla,"+numerosRandom[8];
        losPlatillos[9]="10,Delicia de Xocolatl (1 rebanada),200,Pastel de Chocolate de Metate con Helado de Fresa y Betabel con Mousse de Maracuyá y Aceite de Poleo en Polvo,"+numerosRandom[9];
        //ITALIANA
        
        //JAPONESA
        
        //AÑADIR OBJETOS PLATILLO A LA LISTA
        String lineaAuxiliar = null;//LINEA QUE SERÁ TOKENIZADA
        String unAtributo = null; //CADENA QUE GUARDA UN ATRIBUTO COMO TOKEN DE UN PLATILLO
        //Platillo(int id, String nombre, double precio, String descripcion, int existencias)
        float banderaDeAtributo=0;
        
        for (int i = 0; i < 10; i++) {
            Platillo platilloAuxiliar = new Platillo();//OBJETO QUE GUARDA LA INFORMACIÓN EN TOKENS
            lineaAuxiliar = losPlatillos[i];
            StringTokenizer tokenizerAuxiliar = new StringTokenizer(lineaAuxiliar,",");
            banderaDeAtributo = 0;
            
            while(tokenizerAuxiliar.hasMoreTokens()){
                unAtributo = tokenizerAuxiliar.nextToken();
                if(banderaDeAtributo==0){
                    platilloAuxiliar.setId(parseInt(unAtributo));
                }
                else if  (banderaDeAtributo==1){
                    platilloAuxiliar.setNombre(unAtributo);
                }
                else if  (banderaDeAtributo==2){
                    platilloAuxiliar.setPrecio(Double.parseDouble(unAtributo));
                }
                else if  (banderaDeAtributo==3){
                    platilloAuxiliar.setDescripcion(unAtributo);
                }
                else if  (banderaDeAtributo==4){
                    platilloAuxiliar.setExistencias(Integer.parseInt(unAtributo));
                }
                banderaDeAtributo++;
            }
            //System.out.println(platilloAuxiliar);
            menu.add(platilloAuxiliar);    
        }//TERMINA FOR
    }
    
    /**
     * Método que genera un número aleatorio para el menú.
     * @return Retorna un número aleatorio entre 20 y 100.
     */
    public int crearNumRandom(){
            Random r = new Random();
            int minimo = 20, maximo = 100;
            int numRandom = r.nextInt(maximo-minimo) + minimo;
            return numRandom;
    }
    /**
     * Método que imprime la sección del menú solicitada y no muestra platillos sin existencias.
     * @param tipoComida Entero que es 1 para menú Mexicano, 2 para menú Italiano, 3 para Menú Japonés.
     */
    public void mostrarMenu(int tipoComida){
        if(tipoComida==1){//MEXICANA
            for (int i = 0; i < 10; i++) {
                if(menu.get(i).getExistencias()==0){
                    continue;
                }
                else{
                    System.out.println(menu.get(i));
                } 
            }
        }
        else if(tipoComida==2){//ITALIANA
            for (int i = 10; i < 19; i++) {
                if(menu.get(i).getExistencias()==0){
                    continue;
                }
                else{
                    System.out.println(menu.get(i));
                } 
            }
        }
        else if(tipoComida==3){//JAPONESA
            for (int i = 20; i < 30; i++) {
                if(menu.get(i).getExistencias()==0){
                    continue;
                }
                else{
                    System.out.println(menu.get(i));
                } 
            }
        }
    }

}
