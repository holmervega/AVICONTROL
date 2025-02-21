package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

    public boolean validarUsuario(String nombreUsuario, String contrasenaUsuario) {
        boolean existe = false;

        Conexion miconexion = new Conexion();
        Connection nuevaCon = miconexion.getConn();

        try {
            String querySQL = "SELECT * FROM Usuarios WHERE nombreUsuario = ? AND contrasenaUsuario = ?";
            PreparedStatement sentencia = nuevaCon.prepareStatement(querySQL);
            sentencia.setString(1, nombreUsuario);
            sentencia.setString(2, contrasenaUsuario);
            ResultSet rs = sentencia.executeQuery();

            if (rs.next()) {
                existe = true; 
            }
        } catch (Exception ex) {
            System.err.println("Error en validarUsuario: " + ex.getMessage());
        }

        return existe; 
    }
}
