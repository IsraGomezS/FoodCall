package proyectofinal.modelo;

/**
 * Clase que crea a un platillo.
 * @author Foodcall
 */
public class Platillo {
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private int existencias;
    /**
     * Constructor vacío.
     */
    public Platillo() {
    }
    
    /**
     * Constructor con parámetros.
     * @param id Número de identificación del platillo.
     * @param nombre Nombre del platillo.
     * @param precio Precio del platillo.
     * @param descripcion Descripción de ingredientes y/o preparación del platillo.
     * @param existencias Número de existencias del platillo.
     */
    public Platillo(int id, String nombre, double precio, String descripcion, int existencias) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.existencias = existencias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    
    /**
     * Método toString del platillo que imprime sus atributos como cadena.
     * @return Atributos de un objeto Platillo como cadena, cada atributo lo separa una coma.
     */
    @Override
    public String toString() {
        return id + "," + nombre + "," + precio + "," + descripcion+ "," + existencias ;
    }   
}
