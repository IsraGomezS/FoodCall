package proyectofinal;

//ZONA DE IMPORTACIONES
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import proyectofinal.Controlador.BaseDeDatos;
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
        //CREACIÓN DEL MENÚ1
        BaseDeDatos baseMenu =new BaseDeDatos("Menu",5);
        BaseDeDatos baseVentas =new BaseDeDatos("Ventas",4);
        Menu elMenu = new Menu();
        elMenu.crearMenu();
        //OBJETO pedido de tipo Pedido que guarda las ventas del día.
        Pedido pedido = new Pedido();
        String inicio=null;
        
        //BIENVENIDA
        try{
            int banderaInfinita=0;
            do {

                inicio="Bienvenido a Foodcall.";

                //INICIAR SESIÓN, REGISTRARSE
                inicio+="\nTeclee el número de la opción que desea realizar:\n\n";
                int opcion = 0;//VARIABLE QUE GUARDA LA OPCIÓN TECLEADA
                Scanner entrada = new Scanner(System.in);
                baseMenu.creearBaseDeDatos();
                baseMenu.agregarBaseDeDatosCompleta(elMenu.getMenu());
                baseVentas.creearBaseDeDatos();
                baseVentas.agregarBaseDeDatosCompletaPedidos(pedido);
               // JOptionPane.showMessageDialog(null, "Bien, tu nombre es "+nombre);
                do {

                    opcion=Integer.parseInt(JOptionPane.showInputDialog(inicio+
                            "1. Llamar al módulo generador de 100 pedidos aleatorios."
                            + "\n2. Imprimir el menú entero."
                            + "\n3. Modificar el número de existencias de los platillos."
                            + "\n4. Crear un pedido."
                            + "\n5. Imprimir base de datos de los platillos listos para ser empacados."
                            + "\n6. Imprimir base de datos de las ventas realizadas."));
                } while ( opcion < 1 || opcion > 6 );

                //System.out.println(opcion);
                switch(opcion){

                    case 1://MÓDULO GENERADOR DE PEDIDOS

                        JOptionPane.showMessageDialog(null,"Generando 100 pedidos...\n");
                        pedido.moduloGeneradorPedidos(elMenu.menu, pedido.getVentasConcretadas());
                        JOptionPane.showMessageDialog(null,"Se han generado los 100 pedidos exitosamente.");
                        break;

                    case 2://IMPRIMIR MENÚ COMPLETO
                        String[] menus = new String[3];
                        JOptionPane.showMessageDialog(null,"----------------------FOODCALL----------------------");
                        menus[0]=elMenu.mostrarMenu(1);
                        JOptionPane.showMessageDialog(null,menus[0]);
                        elMenu.mostrarMenu(2);
                        menus[1]=elMenu.mostrarMenu(2);
                        JOptionPane.showMessageDialog(null,menus[1]);
                        elMenu.mostrarMenu(3);
                        menus[2]=elMenu.mostrarMenu(3);
                        JOptionPane.showMessageDialog(null,menus[2]);
                        break;

                    case 3://MÓDULO CRUD PLATILLOS
                        do {
                        opcion=Integer.parseInt(JOptionPane.showInputDialog("\nMódulo CRUD Platillos"+
                                "\n¿De qué menú desea hacer modificaciones?"+
                                "\n1. Mexicano"+
                                "\n2. Italiano"+
                                "\n3. Japonés")); 
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
                        do {
                            opcion=Integer.parseInt(JOptionPane.showInputDialog("\nCreando un pedido."
                                + "\n¿De qué menú le gustaría ordenar?"
                                    +"\n1. Mexicano"
                                    +"\n2. Italiano"
                                    +"\n3. Japonés"));
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
                        String base5=null;
                        for (int i = 0; i < 30; i++) {
                            base5+="\n"+elMenu.getMenu().get(i);
                        }
                        JOptionPane.showMessageDialog(null,base5);
                        break;

                    case 6://IMPRIMIR BASE DE DATOS VENTAS
                        String base6=null;
                        for (int i = 0; i < pedido.getVentasConcretadas().size(); i++) {
                            base6+="\n"+pedido.getVentasConcretadas().get(i);
                        }
                        JOptionPane.showMessageDialog(null,base6);
                        break;
                    default:

                        break;
                }

            }while (banderaInfinita==0);
            
        }catch(NumberFormatException ex){
            System.out.println("No es numero");
    }
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
        String menuVista=null;
        if(banderaMenu==1){
            minimo=0;
            maximo=10;
            System.out.println("----------------------MENÚ MEXICANO----------------------");
            menuVista="----------------------MENÚ MEXICANO----------------------\n";
        }
        else if(banderaMenu==2){
            minimo=10;
            maximo=20;
            System.out.println("----------------------MENÚ ITALIANO----------------------");
            menuVista="----------------------MENÚ ITALIANO----------------------\n";
        }
        else if(banderaMenu==3){
            minimo=20;
            maximo=30;
            System.out.println("----------------------MENÚ JAPONÉS----------------------");
            menuVista="----------------------MENÚ JAPONÉS----------------------\n";
        }
        //IMPRIMIR MENÚ
        for (int i=minimo; i < maximo; i++) {
            System.out.println(menu.get(i).getPrecio()+" MXN - "+menu.get(i).getNombre()+" ID del platillo: "+menu.get(i).getId()+"\nExistencias:"+menu.get(i).getExistencias()+"\t- "+menu.get(i).getDescripcion()+"\n");
            menuVista+=menu.get(i).getPrecio()+" MXN - "+menu.get(i).getNombre()+" - ID del platillo: "+menu.get(i).getId()+"\nExistencias:"+menu.get(i).getExistencias()+"\t- "+menu.get(i).getDescripcion()+"\n";
        }
        //ESCOGER PLATILLO
        menuVista+="\nIngrese el ID del platillo que desea modificar:";
        do {
            opcionID=Integer.parseInt(JOptionPane.showInputDialog(menuVista));
        } while (opcionID < minimo || opcionID > maximo-1);
        //¿QUIERE AÑADIR O ELIMINAR?
        String preguntaAE=null;
        preguntaAE="Selecciona si desea agregar o eliminar platillos:";
        preguntaAE+="\n1. Agregar";
        preguntaAE+="\n2. Eliminar";
        do {
            opcion=Integer.parseInt(JOptionPane.showInputDialog(preguntaAE));
        } while (opcion < 1 || opcion > 2);
        if(opcion==1){
            opcionCantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántos platillos desea añadir:"));
            menu.get(opcionID).setExistencias(menu.get(opcionID).getExistencias()+opcionCantidad);//GUARDANDO CAMBIOS
        }
        else if (opcion==2) {
            do {
                opcionCantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántos platillos desea eliminar (No puede eliminar más platillos que el número de existencias actuales)"));
            } while (opcionCantidad>menu.get(opcionID).getExistencias());
            menu.get(opcionID).setExistencias(menu.get(opcionID).getExistencias()-opcionCantidad);//GUARDANDO CAMBIOS
        }
        BaseDeDatos bdC =new BaseDeDatos("Menu", 5);
        bdC.agregarBaseDeDatosCompleta(menu);
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
        String tick=null;
        BaseDeDatos paraTikets= new BaseDeDatos();
        Scanner entrada = new Scanner(System.in);
        
        do {
            opcionCuantosPlatillos=Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos platillos diferentes desea ordenar?"));
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
            

            //ESCOGER PLATILLO
            do {
                //IMPRIMIR MENÚ
                opcionID=Integer.parseInt(JOptionPane.showInputDialog(menu.mostrarMenu(banderaMenu)+"Ingrese el ID del platillo "+(i+1)+" que desea ordenar:"));
            } while (opcionID < minimo || opcionID > maximo);
            pedidoAuxiliar.setNumPlatillo(opcionID);
            arregloAuxiliarID[i]=opcionID;
            //ESCOGER CANTIDAD
            do {
                opcionCantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuántos platillos del mismo tipo desea agregar a su orden (No puede ordenar más platillos que el número de existencias actuales):"));
            } while (opcionCantidad>menu.getMenu().get(opcionID).getExistencias()||opcionCantidad<1);
            pedidoAuxiliar.setCantidad(opcionCantidad);
            arregloAuxiliarCantidades[i]=opcionCantidad;
            //TIPO DE ENVOLTORIO
            do{
                opcionEnvoltorio=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de envoltorio que desea para su comida:"
                        + "\n1. Cartón."
                        + "\n2. Plástico."));
            }while(opcionEnvoltorio<1 || opcionEnvoltorio>2);
            pedidoAuxiliar.setIdEnvoltorio(opcionEnvoltorio-1);
            //CON CUBIERTOS O NO
            do{
                opcionCubiertos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese si desea incluir cubiertos desechables con su comida:"
                        + "\n1. No."
                        + "\n2. Si"));
            }while(opcionCubiertos<1 || opcionCubiertos>2);
            pedidoAuxiliar.setIdCubiertos(opcionCubiertos-1);

            JOptionPane.showMessageDialog(null,pedidoAuxiliar.imprimirPedido(menu.getMenu(), pedidoAuxiliar, 1));
            
            menu.getMenu().get(opcionID).setExistencias(menu.getMenu().get(opcionID).getExistencias()-opcionCantidad);//GUARDANDO CAMBIOS EN EL MENÚ
            ventas.getVentasConcretadas().add(pedidoAuxiliar);
            total=total+(pedidoAuxiliar.getCantidad())*(menu.getMenu().get(opcionID).getPrecio());
            contadorPlatillos++;
            arregloAuxiliar[i]=ventas.getVentasConcretadas().indexOf(pedidoAuxiliar);
            JOptionPane.showMessageDialog(null,"Platillo registrado exitosamente.");
        }
        do {
            opcionConfirmacion=Integer.parseInt(JOptionPane.showInputDialog("¿Desea confirmar su compra?"
            +"\n1. Sí."
            +"\n2. Cancelar pedido."));
        } while (opcionConfirmacion<1||opcionConfirmacion>2);
        
        if(opcionConfirmacion==1){
            Pedido pedidoAuxiliar= new Pedido();
            for (int i = 0; i < contadorPlatillos; i++) {
                pedidoAuxiliar=ventas.getVentasConcretadas().get(arregloAuxiliar[i]);
                tick+=pedidoAuxiliar.imprimirPedido(menu.getMenu(), pedidoAuxiliar, 1);
            }
            //AQUÍ SE DEBE CREAR EL TICKET COMO ARCHIVO DE TEXTO
            JOptionPane.showMessageDialog(null,"-----TICKET DE COMPRA-----\n"+tick+"\nTOTAL DE LA COMPRA:"+total);
            paraTikets.creearTicket(ventas.getVentasConcretadas().indexOf(pedidoAuxiliar),tick);
        }
        
        else if(opcionConfirmacion==2){
            int tamanio=ventas.getVentasConcretadas().size();
            for (int i = 0; i < contadorPlatillos; i++){
                 ventas.getVentasConcretadas().remove(tamanio-1-i);
                 menu.getMenu().get(arregloAuxiliarID[i]).setExistencias(menu.getMenu().get(arregloAuxiliarID[i]).getExistencias()+arregloAuxiliarCantidades[i]);
             }
            JOptionPane.showMessageDialog(null,"Pedido cancelado."+"\nTOTAL DE LA COMPRA:"+0);
        }
       
    }
    
}
