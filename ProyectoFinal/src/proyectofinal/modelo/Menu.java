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
    public ArrayList <Platillo> menu = new ArrayList <> ();//LISTA QUE CONTENDRÁ LOS PLATILLOS DEL MENÚ
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
        String [] losPlatillos = new String[30];//ARREGLO DE CADENAS, CADA CADENA ES UN PLATILLO
        String [] numerosRandom = new String [30];
        //GENERAR NÚMEROS ALEATORIOS
        for (int i = 0; i < 30; i++) {
            numerosRandom[i]=String.valueOf(crearNumRandom());
        }
        //DECLARACIÓN DE LOS 30 PLATILLOS DISPONIBLES
        //MEXICANA
        losPlatillos[0]="0,Chapulines,200,100g Preparados con Ajo y Chile de Árbol servidos con Guacamole con quesillo y tortillas,"+numerosRandom[0];
        losPlatillos[1]="1,Tostadas de Atún Ahumado (3pzas),290,A la Mexicana Servidos con Lechuga Cremoso de Aguacate Sobre Tostada de Maíz Azul,"+numerosRandom[1];
        losPlatillos[2]="2,Pambazos de Short Rib (3pzas),265,Rellenos de Papa y Bañados en Salsa de Guajillo Acompañados de Lechuga Queso de Ocosingo y Crema,"+numerosRandom[2];
        losPlatillos[3]="3,Clásico Caldo Tlalpeño,190,De Pollo con Caldo de Jitomate Pasilla Mixe y Chipotle Arroz Blanco Vegetales Aguacate y Quesillo,"+numerosRandom[3];
        losPlatillos[4]="4,Huachinango con Mole Chichilo,260,200g con Mole Chichilo Puré de Plátano Chayote Cambray y Ejotes,"+numerosRandom[4];
        losPlatillos[5]="5,Robalo al pastor con Costra de Huitlacoche,250,Piña Tatemada Puré de Piña y Mayonesa de Ajo,"+numerosRandom[5];
        losPlatillos[6]="6,Tacos Rib Eye (3pzas),250,250g con Costra de Queso y Rajas de Chile Poblano,"+numerosRandom[6];
        losPlatillos[7]="7,Filete de Res con Costra de Pepitas de Calabaza,280,Calabaza Támala Tatemada Puré de Calabaza y Salsa de Flor de Calabaza,"+numerosRandom[7];
        losPlatillos[8]="8,Buñuelo con Mousse de Quesillo,170,Con Almendras Garapiñadas y en Polvo Merengue Deshidratado y Granizado de Café de Olla,"+numerosRandom[8];
        losPlatillos[9]="9,Delicia de Xocolatl (1 rebanada),200,Pastel de Chocolate de Metate con Helado de Fresa y Betabel con Mousse de Maracuyá y Aceite de Poleo en Polvo,"+numerosRandom[9];
        //ITALIANA
        losPlatillos[10]="10,Carpaccio de Pulpo,230,400g de Pulpo fileteado servidos con Hongos Confitados en Aceite de Oliva y Aromatizados con Échalotes,"+numerosRandom[10];
        losPlatillos[11]="11,Vitello tonnato,210,Al Vino Blanco Acompañado de Pepinillos con Alcaparras y Huevo Cocido,"+numerosRandom[11];
        losPlatillos[12]="12,Gnocchi di patate,180,Pasta hecha con patata y harina acompañada de queso Ricota,"+numerosRandom[12];
        losPlatillos[13]="13,Risotto ai Funghi Porcini,175,Arroz Carnaroli Cocinado con Setas Fungi Porcini con Panceta de Cerdo y Espolvoreado con Queso Rallado Parmiggiano Reggiano,"+numerosRandom[13];
        losPlatillos[14]="14,Saltimbocca a la Romana,235,Ternera de Res con Prosciutto y Salvia Envuelta en Jamón Serrano,"+numerosRandom[14];
        losPlatillos[15]="15,Osobuco alla Milanese,215,300g de Ossobuco de Ternera Al vino Blanco En su Caldo y Bañada en Gremolatta,"+numerosRandom[15];
        losPlatillos[16]="16,Torta Pasqualina,195,Rellena de Nuez Moscada con Queso Parmesano Rallado y Huevo con Ricota y Espinaca al Vapor,"+numerosRandom[16];
        losPlatillos[17]="17,Lasagne alla Bolognese,270,Al horno Bañada en Salsa Bolognesa y Bechamel con Queso Mozarella Fior di Latte y un Toque de Vino Blanco,"+numerosRandom[17];
        losPlatillos[18]="18,Tiramissu,165,Crema de Zabaione con Vino Marsala y Queso Mascarpone Batido y  Bizcochos de Soletilla Con un Toque de Café y Espolvoreado con Cacao en Polvo,"+numerosRandom[18];
        losPlatillos[19]="19,Panna cotta,185,Pastel Cremoso de Nata Con Escencia de Vainilla y Acompañado de Frutos del Bosque,"+numerosRandom[19];
        //JAPONESA
        losPlatillos[20]="20,Udon,215,Fideos de Arroz Servidos en Caldo de Pescado y Salsa Roja y Mirin Acompañados con Vegetales y Tofu,"+numerosRandom[20];
        losPlatillos[21]="21,Yakisoba,220,Fideos Fritos Acompañados de Verduras Salteadas Carne de Res con Pescado y Mariscos,"+numerosRandom[21];
        losPlatillos[22]="22,Takoyaki,255,Bolas de Pulpo Fritas Envueltas y Fritas en Harina Rellenas de Alga Nori,"+numerosRandom[22];
        losPlatillos[23]="23,Ikayaki,190,Calamar Cocinado a la Parrilla Troceado y Coronado Bañado en Salsa Worcestershire,"+numerosRandom[23];
        losPlatillos[24]="24,Okonomiyaki,260,Tortilla de Harina y Huevo Rellena de Calamar y Gamba Bañana en Salsa Okonomiyaki,"+numerosRandom[24];
        losPlatillos[25]="25,Calamares a la Tempura,250,Anilla de Calamar Rebozados en Masa Tempura Fritos en Aceite de Girasoly Espolvoreados con Rayadura de Limón,"+numerosRandom[25];
        losPlatillos[26]="26,Tataki,285,200g de Salmón Fileteado Marinado en Salsa Roja Sellado en Aceite de Olvida Acompañado de Ensalada Wakame y Sésamo Negro,"+numerosRandom[26];
        losPlatillos[27]="27,Katsudon,290,Donburi de Arroz Gohan Cubierto con Chuleta de Cerdo Rebozada y Huevo Revuelto,"+numerosRandom[27];
        losPlatillos[28]="28,Daifuku,170,Mochis Rellenos de Pasta de Melón y Trozos de Fruta,"+numerosRandom[28];
        losPlatillos[29]="29,Monaka,200,Dulce Tradicional Relleno de Judías Azuki Servido entre Barquillos de Mochi Espolvoreado con Nuez y Semillas de Sésamo y Servido en una Cama de Helado de Café,"+numerosRandom[29];        
        //AÑADIR OBJETOS PLATILLO A LA LISTA
        String lineaAuxiliar = null;//LINEA QUE SERÁ TOKENIZADA
        String unAtributo = null; //CADENA QUE GUARDA UN ATRIBUTO COMO TOKEN DE UN PLATILLO
        //Platillo(int id, String nombre, double precio, String descripcion, int existencias)
        float banderaDeAtributo=0;
        
        for (int i = 0; i < 30; i++) {
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
            int minimo = 100, maximo = 200;
            int numRandom = r.nextInt(maximo-minimo) + minimo;
            return numRandom;
    }
    
    /**
     * Método que imprime la sección del menú solicitada y no muestra platillos sin existencias.
     * @param tipoComida Entero que es 1 para menú Mexicano, 2 para menú Italiano, 3 para Menú Japonés.
     */
    public void mostrarMenu(int tipoComida){
        if(tipoComida==1){//MEXICANA
            System.out.println("----------------------MENÚ MEXICANO----------------------");
            for (int i = 0; i < 10; i++) {
                if(menu.get(i).getExistencias()==0){
                    continue;
                }
                else{
                    System.out.println(menu.get(i).getPrecio()+" MXN - "+menu.get(i).getNombre()+" - ID del platillo: "+menu.get(i).getId()+"\nExistencias:"+menu.get(i).getExistencias()+"\t- "+menu.get(i).getDescripcion()+"\n");
                }
                
            }
        }
        else if(tipoComida==2){//ITALIANA
            System.out.println("----------------------MENÚ ITALIANO----------------------");
            for (int i = 10; i < 20; i++) {
                if(menu.get(i).getExistencias()==0){
                    continue;
                }
                else{
                    System.out.println(menu.get(i).getPrecio()+" MXN - "+menu.get(i).getNombre()+" - ID del platillo: "+menu.get(i).getId()+"\nExistencias:"+menu.get(i).getExistencias()+"\t- "+menu.get(i).getDescripcion()+"\n");
                }
            }
        }
        else if(tipoComida==3){//JAPONESA
            System.out.println("----------------------MENÚ JAPONÉS----------------------");
            for (int i = 20; i < 30; i++) {
                if(menu.get(i).getExistencias()==0){
                    continue;
                }
                else{
                    System.out.println(menu.get(i).getPrecio()+" MXN - "+menu.get(i).getNombre()+" - ID del platillo: "+menu.get(i).getId()+"\nExistencias:"+menu.get(i).getExistencias()+"\t- "+menu.get(i).getDescripcion()+"\n");
                } 
            }
        }
    }

}
