package proyectofinal.vista;

import java.util.Scanner;

/**
 *
 * @author SPARTAN PC
 */
public abstract class Usuario {
    private String usuario, contrasenia;
    
    public Usuario() {
    }
   
    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    //MÉTODOS DEFINIDOS POR EL PROGRAMADOR
    public void acceder(){
        //DESCARGAR USUARIOS DE LA BASE DE DATOS
        
        String user, password;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre de usuario:");
        user = scan.nextLine();
        System.out.println("Ingrese la contraseña:");
        password = scan.nextLine();
        
        //REALIZAR AUTENTICACIÓN
        if(user.equals("AlgunUsuarioDeLaBaseDeDatos") && password.equals("contraseniaDelUsuario")){
            
        }
    }
    
    public void registrarse(){
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Acerca de este usuario:\n" + "Nombre de usuario=" + usuario + "\tContraseña=" + contrasenia;
    }
}
