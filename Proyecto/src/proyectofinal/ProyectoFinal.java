package proyectofinal;

//ZONA DE IMPORTACIONES
import java.util.Scanner;
import proyectofinal.modelo.Menu;

/**
 * Clase principal.
 * @author Foodcall
 */
public class ProyectoFinal {
    
    //MÉTODO PRINCIPAL
    public static void main(String[] args) {
        
        //CREACIÓN DEL MENÚ
        //crearMenu();
        Menu elMenu = new Menu();
        elMenu.crearMenu();
        elMenu.mostrarMenu(1);
        //BIENVENIDA
        System.out.println("\nBienvenido a Foodcall.");
        
        //INICIAR SESIÓN, REGISTRARSE
        System.out.println("Teclee el número de la opción que desea realizar:\n");
        int opcion = 0;//VARIABLES QUE GUARDA LA OPCIÓN TECLEADA
        Scanner entrada = new Scanner(System.in);
        
        do {
            System.out.println("1. Iniciar sesión.");
            System.out.println("2. Registrar nuevo usuario.");
            opcion=Integer.parseInt(entrada.next());
        } while ( opcion < 1 || opcion > 2 );
        
        cls();
        
        System.out.println(opcion);
        switch(opcion){
            case 1:
                //INICIAR SESIÓN
                System.out.println("Teclee el número de usuario que es usted:\n");
                int opcion2 = 0;
                 do {
                    System.out.println("1. Cliente.");
                    System.out.println("2. Empleado.");
                    opcion2=Integer.parseInt(entrada.next());
                } while ( opcion2 < 1 || opcion2 > 2 );
                switch(opcion2){
                    case 1:
                        break;
                    case 2:
                        
                        break;
                }
                
                break;
            case 2:
                //REGISTRAR NUEVO USUARIO
                int opcion3 = 0;
                
                break;
        }
    }
    
    //MÉTODOS DEFINIDOS POR EL PROGRAMADOR
    
    //LIMPIAR PANTALLA
    public static void cls(){
        System.out.println("\nLimpiando pantalla.\n");
    }
    
}
