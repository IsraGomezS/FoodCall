/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.StringTokenizer;
import proyectofinal.modelo.Platillo;

/**
 *
 * @author alanm
 */
public class TranformarBD {
    public ArrayList <Platillo> obtenerBD(Platillo platillAdd){
    try {
            FileReader fr = new FileReader(nombre+".csv");
            BufferedReader br=new BufferedReader(fr);
            String linea = br.readLine();
            while(linea!=null){
            StringTokenizer token=new StringTokenizer(linea,",");
            platilloAuxiliar.setId(parseInt(token.nextToken()));
            platilloAuxiliar.setNombre(token.nextToken());
            platilloAuxiliar.setPrecio(Double.parseDouble(token.nextToken()));
            platilloAuxiliar.setDescripcion(token.nextToken());
            platilloAuxiliar.setExistencias(Integer.parseInt(token.nextToken()));
            linea=br.readLine();
            platillos.add(platilloAuxiliar);
            platilloAuxiliar=null;
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error en base de datos");
        } catch (IOException ex) {
            System.out.println("Error en base de datos");
        }
        return platillos;
    }
}
