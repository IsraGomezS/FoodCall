package proyectofinal.modelo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que crea a un pedido.
 * @author Foodcall
 */
public class Pedido {
    private int numPlatillo, cantidad;
    private int idEnvoltorio;//0 PARA CARTÓN Y 1 PARA PLÁSTICO
    private int idCubiertos;//0 PARA NO Y 1 PARA SÍ
    private ArrayList <Pedido> ventasConcretadas = new ArrayList <> ();//LISTA QUE CONTENDRÁ LOS PLATILLOS DEL MENÚ
    
    /**
     * Constructor vacío.
     */
    public Pedido() {
    }
    
    /**
     * Constructor con parámetros.
     * @param numPlatillo Indica el número de platillo seleccionado por el usuario del menú desplegado.
     * @param cantidad Cantidad de platillos solicitados.
     * @param idEnvoltorio Entero que nos dice el tipo de envoltorio solicitado, 0 para cartón y 1 para plástico.
     * @param idCubiertos Entero que nos dice si el pedido lleva cubiertos desechables, 0 para no y 1 para sí.
     */
    public Pedido(int numPlatillo, int cantidad, int idEnvoltorio, int idCubiertos) {
        this.numPlatillo = numPlatillo;
        this.cantidad = cantidad;
        this.idEnvoltorio = idEnvoltorio;
        this.idCubiertos = idCubiertos;
    }

    public ArrayList<Pedido> getVentasConcretadas() {
        return ventasConcretadas;
    }

    public void setVentasConcretadas(ArrayList<Pedido> ventasConcretadas) {
        this.ventasConcretadas = ventasConcretadas;
    }

    public int getNumPlatillo() {
        return numPlatillo;
    }

    public void setNumPlatillo(int numPlatillo) {
        this.numPlatillo = numPlatillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdEnvoltorio() {
        return idEnvoltorio;
    }

    public void setIdEnvoltorio(int idEnvoltorio) {
        this.idEnvoltorio = idEnvoltorio;
    }

    public int getIdCubiertos() {
        return idCubiertos;
    }

    public void setIdCubiertos(int idCubiertos) {
        this.idCubiertos = idCubiertos;
    }
    
    /**
     * Método que genera un número aleatorio para el menú.
     * @param min Mínimo valor posible generado.
     * @param max Máximo valor posible generado.
     * @return Retorna un número aleatorio de acuerdo a los parámetros maximo y minimo.
     */
    public int crearNumRandom(int min, int max){
            return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    
    /**
     * Método que crea 100 pedidos aleatorios.
     * @param menu Menú actual con los platillos disponibles.
     */
    public void moduloGeneradorPedidos(ArrayList <Platillo> menu ){
        
        for (int i = 0; i < 100; i++) {
            
            Pedido pedidoAuxiliar = new Pedido();
            int indicePedidoAuxiliar=0;
            int existencias=0;
            int cantidadAuxiliar=0;
            //CREAR UN NUEVO PLATILLO HASTA QUE LAS EXISTENCIAS SEAN SUFICIENTES PARA CUBRIR LA DEMANDA
            do {
                indicePedidoAuxiliar = crearNumRandom(0,29);
                existencias=menu.get(indicePedidoAuxiliar).getExistencias();
                cantidadAuxiliar=crearNumRandom(5,10);
            } while (existencias<cantidadAuxiliar);
            //RESTAR LA CANTIDAD SOLICITADA A LAS EXISTENCIAS DEL MENÚ
            menu.get(indicePedidoAuxiliar).setExistencias(menu.get(indicePedidoAuxiliar).getExistencias()-cantidadAuxiliar);
            
            //GUARDAR ATRIBUTOS EN UN OJETO PEDIDO AUXILIAR
            pedidoAuxiliar.setNumPlatillo(indicePedidoAuxiliar);
            pedidoAuxiliar.setCantidad(cantidadAuxiliar);
            pedidoAuxiliar.setIdEnvoltorio(crearNumRandom(0,1));
            pedidoAuxiliar.setIdCubiertos(crearNumRandom(0,1));
            
            //GUARDAR EL PEDIDO EN UN ARRAYLIST DE LAS VENTAS CONCRETADAS
            ventasConcretadas.add(pedidoAuxiliar);
            //System.out.println(pedidoAuxiliar);
            pedidoAuxiliar.imprimirPedido(menu, pedidoAuxiliar,0);
            
        }
    }
    /**
     * Método que imprime un pedido.
     * @param menu Recibe al menú actual con los platillos disponibles.
     * @param pedido Un objeto de tipo Pedido.
     * @param idTicket Indica si se trata de la impresión de un ticket o no, 0 para no, 1 para sí.
     */
    public void imprimirPedido(ArrayList <Platillo> menu, Pedido pedido, int idTicket){
        if (idTicket==1){
            System.out.println("\n------Producto------");
        }
        System.out.println("Platillo: "+menu.get(pedido.numPlatillo).getNombre());
        System.out.println("Precio: "+menu.get(pedido.numPlatillo).getPrecio()+" MXN");
        System.out.println("Descripcion: "+menu.get(pedido.numPlatillo).getDescripcion());
        int auxiliar = pedido.idEnvoltorio;
        String envoltorio=null;
        if(auxiliar==0){
            envoltorio="Cartón";
        }
        else if(auxiliar==1){
            envoltorio="Plástico";
        }
        System.out.println("Tipo de envoltorio: "+envoltorio);
        auxiliar = pedido.idCubiertos;
        String cubiertos = null;
        if(auxiliar==0){
            cubiertos="No";
        }
        else if(auxiliar==1){
            cubiertos="Sí";
        }
        
        System.out.println("Incluye cubiertos desechables: "+cubiertos);
        System.out.println("Cantidad solicitada: "+pedido.cantidad);
        System.out.println("Total: "+(pedido.cantidad)*menu.get(pedido.numPlatillo).getPrecio()+" MXN\n");
    }
    
    /**
     * Método toString de un pedido que imprime sus atributos como cadena.
     * @return Atributos de un objeto Pedido como cadena, cada atributo lo separa una coma.
     */
    @Override
    public String toString() {
        return numPlatillo + "," + cantidad + "," + idEnvoltorio + "," + idCubiertos;
    }

}
