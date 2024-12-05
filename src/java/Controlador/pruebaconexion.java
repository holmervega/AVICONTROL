
package Controlador;

import java.sql.Connection;

/**
 *
 * @author holmer
 */
public class pruebaconexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion micon = new Conexion();
        
        Connection reg = micon.getConn();
    }
    
}
