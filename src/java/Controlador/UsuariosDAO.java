package Controlador;

import Modelo.Persona;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class UsuariosDAO {

    public String AdicionarUsuarios(Usuarios usuarios) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO Usuarios(nombreUsuario, contrasenaUsuario)"
                    + "VALUES(?,?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setString(1, usuarios.getNombreUsuario());
            sentencia.setString(2, usuarios.getContrasenaUsuario());
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en RolesDAO" + ex.getMessage());

        }
        return miRespuesta;

    }

    public boolean ConsultarUsuario(String nombreUsuario, String contrasenaUsuario) {
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
            System.err.println("Error al validar Usuario: " + ex.getMessage());
        }

        return existe;
    }

    public ArrayList<Usuarios> ObtenerTodosLosUsuarios() {
        ArrayList<Usuarios> listaUsuarios = new ArrayList<>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon = miconexion.getConn();

        try {
            Statement sentencia = nuevaCon.createStatement();
            String querySQL = "SELECT u.idUsuarios, u.nombreUsuario, u.contrasenaUsuario, "
                    + "p.idPersona, p.numeroIdentificacion, p.nombres, p.apellidos, p.telefono, p.correo, p.direccion "
                    + "FROM Usuarios u "
                    + "JOIN Persona p ON u.idUsuarios =  p.Usuarios_idUsuarios  "
                    + "ORDER BY u.idUsuarios";
            ResultSet rs = sentencia.executeQuery(querySQL);

            while (rs.next()) {
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuarios(rs.getInt("idUsuarios"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setContrasenaUsuario(rs.getString("contrasenaUsuario"));

                // Crear objeto Persona y asignarlo al usuario
                Persona persona = new Persona();

                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNumeroIdentificacion(rs.getInt("numeroIdentificacion"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setTelefono(rs.getInt("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setDireccion(rs.getString("direccion"));
                
                
                usuario.setPersona(persona);
                listaUsuarios.add(usuario);
            }

            // Verificamos si realmente hay datos
            System.out.println("Usuarios obtenidos: " + listaUsuarios.size());

        } catch (Exception ex) {
            System.err.println("Error al obtener usuarios: " + ex.getMessage());
        }

        return listaUsuarios;
    }

    public ArrayList<Usuarios> ConsultarListaUsuarios(String nombreUsuario) {
        ArrayList<Usuarios> miListadoUsuarios = new ArrayList<Usuarios>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "SELECT idUsuarios, nombreUsuario, contrasenaUsuario "
                    + "FROM Usuarios "
                    + "WHERE nombreUsuario LIKE '%" + nombreUsuario + "%' "
                    + "ORDER BY idUsuarios";

            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                Usuarios usuarios = new Usuarios();
                usuarios.setIdUsuarios(rs.getInt(1));
                usuarios.setNombreUsuario(rs.getString(2));
                usuarios.setContrasenaUsuario(rs.getString(3));
                miListadoUsuarios.add(usuarios);
            }
            return miListadoUsuarios;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return miListadoUsuarios;
        }
    }
}
