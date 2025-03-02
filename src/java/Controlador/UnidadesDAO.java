
package Controlador;

import Modelo.Unidades;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class UnidadesDAO {
    
      public String adicionarDescripcionUnidades(Unidades unidades) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();
        
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO Unidades(descripcionUnidades)"
                    +"VALUES(?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1,unidades.getDescripcionUnidades());
            sentencia.execute();
            miRespuesta = "";                
        }catch (Exception ex){
            miRespuesta = ex.getMessage();
              System.out.println("Ocurrio un error en UnidadesDAO"+ex.getMessage());
            
        }
        return miRespuesta;        
     
    }   
    
}
