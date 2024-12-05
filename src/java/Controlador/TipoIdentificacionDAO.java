
package Controlador;

import Modelo.TipoIdentificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class TipoIdentificacionDAO {
    
    public String adicionarTipoIdentificacion(TipoIdentificacion tipoidentificacion) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();
        
        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO TipoIdentificacion(descripcionTipoIdentificacion)"
                    +"VALUES(?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1,tipoidentificacion.getDescripcionTipoIdentificacion());
            sentencia.execute();
            miRespuesta = "";                
        }catch (Exception ex){
            miRespuesta = ex.getMessage();
              System.out.println("Ocurrio un error en TipoIdentificacionDAO"+ex.getMessage());
            
        }
        return miRespuesta;        
     
    }        
}
