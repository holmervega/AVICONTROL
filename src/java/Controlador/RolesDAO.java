package Controlador;

import Modelo.Roles;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class RolesDAO {

    public String AdicionarRoles(Roles roles) {

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

    public Roles ConsultarRoles(int idRoles) {
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

    public ArrayList<Roles> ConsultarListaRoles(String descripcionRol) {
        ArrayList<Roles> miListadoRoles = new ArrayList<Roles>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "select idRoles, descripcionRol from Roles where descripcionRol like '%" + descripcionRol + "%' ORDER BY idRoles";

            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                Roles roles = new Roles();
                roles.setIdRoles(rs.getInt(1));
                roles.setDescripcionRol(rs.getString(2));
                miListadoRoles.add(roles);
            }
            return miListadoRoles;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return miListadoRoles;
        }
    }

    public String ActualizarRoles(Roles roles) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "UPDATE roles SET descripcionRol=?WHERE idRoles=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, roles.getDescripcionRol());//nuevo nombre
            sentencia.setInt(2, roles.getIdRoles());// id BD existe

            int filasAfectadas = sentencia.executeUpdate();// ejecutando la actualizacion 
            
            if (filasAfectadas ==0){
                miRespuesta= "No se encontro rol con este ID";
            }
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en RolesDAO" + ex.getMessage());

        }
        return miRespuesta;
    }

}
