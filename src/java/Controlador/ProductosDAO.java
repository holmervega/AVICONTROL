
package Controlador;

import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ProductosDAO {
     public String adicionarPrecioProductos(Productos productos) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();
        
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO Productos(precio)"
                    +"VALUES(?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setDouble(1,productos.getPrecio());
            sentencia.execute();
            miRespuesta = "";                
        }catch (Exception ex){
            miRespuesta = ex.getMessage();
              System.out.println("Ocurrio un error en ProductosDAO"+ex.getMessage());
            
        }
        return miRespuesta;        
     
    }  
    
}
