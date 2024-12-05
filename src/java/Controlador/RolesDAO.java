package Controlador;

import Modelo.Roles;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class RolesDAO {

    public String adicionarRoles(Roles roles) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO Roles(descripcionRol)"
                    + "VALUES(?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, roles.getDescripcionRol());
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en RolesDAO" + ex.getMessage());

        }
        return miRespuesta;

    }

    public Roles consultarRoles(int idRoles) {
        Roles roles = null;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "select idRoles, descripcionRol from Roles where idRoles =" + idRoles;
            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                roles = new Roles();
                roles.setIdRoles(rs.getInt(1));
                roles.setDescripcionRol(rs.getString(2));
            }
            return roles;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return roles;
        }
    }
}
