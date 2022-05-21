package proyectofinal;

//ZONA DE IMPORTACIONES
import java.util.ArrayList;
import java.util.Scanner;
import proyectofinal.modelo.Menu;
import proyectofinal.modelo.Pedido;
import proyectofinal.modelo.Platillo;

/**
 * Clase principal.
 * @author Foodcall
 */
public class ProyectoFinal {
    
    //MÉTODO PRINCIPAL
    public static void main(String[] args) {
        
        //CREACIÓN DEL MENÚ
        Menu elMenu = new Menu();
        elMenu.crearMenu();
        //OBJETO pedido de tipo Pedido que guarda las ventas del día.
        Pedido pedido = new Pedido();
        //BIENVENIDA
        int banderaInfinita=0;
        do {
            
            System.out.println("\nBienvenido a Foodcall.");

            //INICIAR SESIÓN, REGISTRARSE
            System.out.println("\nTeclee el número de la opción que desea realizar:\n");
            int opcion = 0;//VARIABLE QUE GUARDA LA OPCIÓN TECLEADA
            Scanner entrada = new Scanner(System.in);

            do {
                System.out.println("1. Llamar al módulo generador de 100 pedidos aleatorios.");
                System.out.println("2. Imprimir el menú entero.");
                System.out.println("3. Modificar el número de existencias de los platillos.");
                System.out.println("4. Crear un pedido.");
                System.out.println("5. Imprimir base de datos de los platillos listos para ser empacados.");
                System.out.println("6. Imprimir base de datos de las ventas realizadas.");
                opcion=Integer.parseInt(entrada.next());
            } while ( opcion < 1 || opcion > 6 );

            //System.out.println(opcion);
            switch(opcion){

                case 1://MÓDULO GENERADOR DE PEDIDOS
                    
                    System.out.println("Generando 100 pedidos...\n");
                    pedido.moduloGeneradorPedidos(elMenu.menu);
                    System.out.println("\nSe han generado los 100 pedidos exitosamente.");
                    break;
                    
                case 2://IMPRIMIR MENÚ COMPLETO
                    System.out.println("----------------------FOODCALL----------------------");
                    elMenu.mostrarMenu(1);
                    elMenu.mostrarMenu(2);
                    elMenu.mostrarMenu(3);
                    break;
                    
                case 3://MÓDULO CRUD PLATILLOS
                    System.out.println("\nMódulo CRUD Platillos");
                    System.out.println("\n¿De qué menú desea hacer modificaciones?");
                    do {
                       System.out.println("1. Mexicano");
                       System.out.println("2. Italiano");
                       System.out.println("3. Japonés");
                       opcion=Integer.parseInt(entrada.next()); 
                    } while (opcion < 1 || opcion > 3);
                    switch (opcion){
                        
                        case 1:
                            moduloCRUD(1,elMenu.menu);
                            break;
                            
                        case 2:
                            moduloCRUD(2,elMenu.menu);
                            break;
                            
                        case 3:
                            moduloCRUD(3,elMenu.menu); 
                            break;
                    }
                    break;

                case 4: //CREAR PEDIDOS
                    System.out.println("\nCreando un pedido.");
                    System.out.println("¿De qué menú le gustaría ordenar?");
                    do {
                       System.out.println("1. Mexicano");
                       System.out.println("2. Italiano");
                       System.out.println("3. Japonés");
                       opcion=Integer.parseInt(entrada.next()); 
                    } while (opcion < 1 || opcion > 3);
                    switch (opcion){
                        
                        case 1:
                            moduloPedidos(1,elMenu,pedido);
                            break;
                            
                        case 2:
                            moduloPedidos(2,elMenu,pedido);
                            break;
                            
                        case 3:
                            moduloPedidos(3,elMenu,pedido); 
                            break;
                    }
                    break;

                case 5://IMPRIMIR BASE DE DATOS PLATILLOS
                    System.out.println(elMenu.getMenu());
                    break;

                case 6://IMPRIMIR BASE DE DATOS VENTAS
                    System.out.println(pedido.getVentasConcretadas());
                    break;
            }
            
        }while (banderaInfinita==0);
    }
    
    //MÉTODOS DEFINIDOS POR EL PROGRAMADOR
    
    /**
     * Módulo CRUD Platillos: Método que permite crear y borrar existencias de platillos del Menú.
     * @param banderaMenu Indica el menú por tipo de comida que debe mostrarse, 1 para mexicano, 2 para italiano, 3 para japonés.
     * @param menu Menú actual con los platillos listos para venderse.
     */
    public static void moduloCRUD(int banderaMenu, ArrayList <Platillo> menu){
        int maximo = 0;
        int minimo = 0;
        int opcion=0;
        int opcionID = 0;//VARIABLE QUE GUARDA EL ID DEL PLATILLO POR MODIFICARSE
        int opcionCantidad=0; //NÚMERO DE PLATILLOS QUE SE AÑADEN O ELIMINAN
        Scanner entrada = new Scanner(System.in);
        
        if(banderaMenu==1){
            minimo=0;
            maximo=10;
            System.out.println("----------------------MENÚ MEXICANO----------------------");
        }
        else if(banderaMenu==2){
            minimo=10;
            maximo=20;
            System.out.println("----------------------MENÚ ITALIANO----------------------");
        }
        else if(banderaMenu==3){
            minimo=20;
            maximo=30;
            System.out.println("----------------------MENÚ JAPONÉS----------------------");
        }
        //IMPRIMIR MENÚ
        for (int i=minimo; i < maximo; i++) {
            System.out.println(menu.get(i).getPrecio()+" MXN - "+menu.get(i).getNombre()+" ID del platillo: "+menu.get(i).getId()+"\nExistencias:"+menu.get(i).getExistencias()+"\t- "+menu.get(i).getDescripcion()+"\n");
        }
        //ESCOGER PLATILLO
        System.out.println("Ingrese el ID del platillo que desea modificar:");
        do {
            opcionID=Integer.parseInt(entrada.next());
        } while (opcionID < minimo || opcionID > maximo-1);
        //¿QUIERE AÑADIR O ELIMINAR?
        System.out.println("Selecciona si desea agregar o eliminar platillos:");
        System.out.println("1. Agregar");
        System.out.println("2. Eliminar");
        do {
            opcion=Integer.parseInt(entrada.next());
        } while (opcion < 1 || opcion > 2);
        if(opcion==1){
            System.out.println("Ingrese cuántos platillos desea añadir:");
            opcionCantidad=Integer.parseInt(entrada.next());
            menu.get(opcionID).setExistencias(menu.get(opcionID).getExistencias()+opcionCantidad);//GUARDANDO CAMBIOS
        }
        else if (opcion==2) {
            System.out.println("Ingrese cuántos platillos desea eliminar (No puede eliminar más platillos que el número de existencias actuales):");
            do {
                opcionCantidad=Integer.parseInt(entrada.next());
            } while (opcionCantidad>menu.get(opcionID).getExistencias());
            menu.get(opcionID).setExistencias(menu.get(opcionID).getExistencias()-opcionCantidad);//GUARDANDO CAMBIOS
        }
    }
    /**
     * Método que permite crear un pedido de n Platillos distintos.
     * @param banderaMenu Indica el menú que debe imprimirse, 1 para mexicano, 2 para italiano, 3 para japonés.
     * @param menu Menú actual con los platillos listos para venderse.
     * @param ventas 
     */
    public static void moduloPedidos(int banderaMenu, Menu menu,Pedido ventas){
        int maximo = 0;
        int minimo = 0;
        int opcionID = 0;//VARIABLE QUE GUARDA EL ID DEL PLATILLO POR MODIFICARSE
        int opcionCantidad=0; //NÚMERO DE PLATILLOS QUE SE AÑADEN O ELIMINAN
        int opcionEnvoltorio=0;
        int opcionCubiertos=0;
        int opcionConfirmacion=0;
        int opcionCuantosPlatillos=0;
        int contadorPlatillos=0;
        double total=0;
        
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("¿Cuántos platillos diferentes desea ordenar?");
        do {
            opcionCuantosPlatillos=Integer.parseInt(entrada.next());
        } while (opcionCuantosPlatillos < 1 );
        
        int [] arregloAuxiliar = new int [opcionCuantosPlatillos];//GUARDA LOS ÍNDICES DE LOS PLATILLOS PEDIDOS
        int [] arregloAuxiliarCantidades = new int [opcionCuantosPlatillos];
        int [] arregloAuxiliarID = new int [opcionCuantosPlatillos];
        
        for (int i = 0; i < opcionCuantosPlatillos; i++) {
            Pedido pedidoAuxiliar= new Pedido();
            if(banderaMenu==1){
            minimo=0;
            maximo=9;
            }
            else if(banderaMenu==2){
                minimo=10;
                maximo=19;
            }
            else if(banderaMenu==3){
                minimo=20;
                maximo=29;
            }
            //IMPRIMIR MENÚ
            menu.mostrarMenu(banderaMenu);

            //ESCOGER PLATILLO
            System.out.println("Ingrese el ID del platillo "+(i+1)+" que desea ordenar:");
            do {
                opcionID=Integer.parseInt(entrada.next());
            } while (opcionID < minimo || opcionID > maximo);
            pedidoAuxiliar.setNumPlatillo(opcionID);
            arregloAuxiliarID[i]=opcionID;
            //ESCOGER CANTIDAD
            System.out.println("Ingrese cuántos platillos del mismo tipo desea agregar a su orden (No puede ordenar más platillos que el número de existencias actuales):");
            do {
                opcionCantidad=Integer.parseInt(entrada.next());
            } while (opcionCantidad>menu.getMenu().get(opcionID).getExistencias()||opcionCantidad<1);
            pedidoAuxiliar.setCantidad(opcionCantidad);
            arregloAuxiliarCantidades[i]=opcionCantidad;
            //TIPO DE ENVOLTORIO
            System.out.println("Ingrese el tipo de envoltorio que desea para su comida:");
            System.out.println("1. Cartón.");
            System.out.println("2. Plástico.");
            do{
                opcionEnvoltorio=Integer.parseInt(entrada.next());
            }while(opcionEnvoltorio<1 || opcionEnvoltorio>2);
            pedidoAuxiliar.setIdEnvoltorio(opcionEnvoltorio-1);
            //CON CUBIERTOS O NO
            System.out.println("Ingrese si desea incluir cubiertos desechables con su comida:");
            System.out.println("1. No.");
            System.out.println("2. Sí.");
            do{
                opcionCubiertos=Integer.parseInt(entrada.next());
            }while(opcionCubiertos<1 || opcionCubiertos>2);
            pedidoAuxiliar.setIdCubiertos(opcionCubiertos-1);

            pedidoAuxiliar.imprimirPedido(menu.getMenu(), pedidoAuxiliar, 1);
            
            menu.getMenu().get(opcionID).setExistencias(menu.getMenu().get(opcionID).getExistencias()-opcionCantidad);//GUARDANDO CAMBIOS EN EL MENÚ
            ventas.getVentasConcretadas().add(pedidoAuxiliar);
            total=total+(pedidoAuxiliar.getCantidad())*(menu.getMenu().get(opcionID).getPrecio());
            contadorPlatillos++;
            arregloAuxiliar[i]=ventas.getVentasConcretadas().indexOf(pedidoAuxiliar);
            System.out.println("Platillo registrado exitosamente.");
        }

        System.out.println("¿Desea confirmar su compra?");
        System.out.println("1. Sí.");
        System.out.println("2. Cancelar pedido.");
        do {
            opcionConfirmacion=Integer.parseInt(entrada.next());
        } while (opcionConfirmacion<1||opcionConfirmacion>2);
        
        if(opcionConfirmacion==1){
            System.out.println("\n-----TICKET DE COMPRA-----");
            Pedido pedidoAuxiliar= new Pedido();
            for (int i = 0; i < contadorPlatillos; i++) {
                pedidoAuxiliar=ventas.getVentasConcretadas().get(arregloAuxiliar[i]);
                pedidoAuxiliar.imprimirPedido(menu.getMenu(), pedidoAuxiliar, 1);
            }
            //AQUÍ SE DEBE CREAR EL TICKET COMO ARCHIVO DE TEXTO
            System.out.println("TOTAL DE LA COMPRA:"+total);
        }
        
        else if(opcionConfirmacion==2){
            int tamanio=ventas.getVentasConcretadas().size();
            for (int i = 0; i < contadorPlatillos; i++){
                 ventas.getVentasConcretadas().remove(tamanio-1-i);
                 menu.getMenu().get(arregloAuxiliarID[i]).setExistencias(menu.getMenu().get(arregloAuxiliarID[i]).getExistencias()+arregloAuxiliarCantidades[i]);
             }
            System.out.println("Pedido cancelado.");
            System.out.println("TOTAL DE LA COMPRA:"+0);
        }
    }

}
