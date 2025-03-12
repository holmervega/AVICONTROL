package Controlador;

import Modelo.Persona;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public class PersonaDAO {

    public ArrayList<Persona> ConsultarListaPersona(String numeroIdentificacion) {
        ArrayList<Persona> miListadoPersona = new ArrayList<Persona>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "SELECT idPersona, numeroIdentificacion, nombres, apellidos, telefono, correo, direccion "
                    + "FROM Persona "
                    + "WHERE numeroIdentificacion LIKE '%" + numeroIdentificacion + "%' "
                    + "ORDER BY idPersona";

            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt(1));
                persona.setNumeroIdentificacion(rs.getInt(2));
                persona.setNombres(rs.getString(3));
                persona.setApellidos(rs.getString(4));
                persona.setTelefono(rs.getInt(5));
                persona.setCorreo(rs.getString(6));
                persona.setDireccion(rs.getString(7));
                miListadoPersona.add(persona);

                return miListadoPersona; 
            }

        } catch (Exception ex) { 
            System.err.println(ex.getMessage());
        }

        return miListadoPersona;
    }
    
     public ArrayList<Persona> ObtenerTodasLasPersonas() {
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String querySQL = "SELECT idPersona, numeroIdentificacion, nombres, apellidos, telefono, correo, direccion FROM Persona ORDER BY idPersona";
            ResultSet rs = sentencia.executeQuery(querySQL);

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNumeroIdentificacion(rs.getInt("numeroIdentificacion"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setTelefono(rs.getInt("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setDireccion(rs.getString("direccion"));
                listaPersonas.add(persona);
            }

            // Verificamos si realmente hay datos
            System.out.println("Personas obtenidos: " + listaPersonas.size());

        } catch (Exception ex) {
            System.err.println("Error al obtener usuarios: " + ex.getMessage());
        }

        return listaPersonas;
    }
}
