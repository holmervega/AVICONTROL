package Controlador;

import Modelo.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductosDAO {

    public String adicionarPrecioProductos(Productos productos) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO Productos(precio)"
                    + "VALUES(?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setDouble(1, productos.getPrecio());
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en ProductosDAO" + ex.getMessage());

        }
        return miRespuesta;

    }

    public Productos ConsultarProductos(int idProductos) {
        Productos productos = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "select idProductos, precio from Productos where idProductos =" + idProductos;
            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                productos = new Productos();
                productos.setIdProductos(rs.getInt(1));
                productos.setPrecio(rs.getInt(2));
            }
            return productos;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return productos;
        }
    }

    public ArrayList<Productos> ConsultarListaPrecios(String precio) {
        ArrayList<Productos> miListadoProductos = new ArrayList<Productos>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "select idProductos, precio from Productos where precio like '%" + precio + "%' ORDER BY idProductos";

            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                Productos productos = new Productos();
                productos.setIdProductos(rs.getInt(1));
                productos.setPrecio(rs.getInt(2));
                miListadoProductos.add(productos);
            }
            return miListadoProductos;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return miListadoProductos;
        }
    }

    public String ActualizarProductos(Productos productos) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "UPDATE productos SET precio=? WHERE idProductos=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setDouble(1, productos.getPrecio());//nuevo nombre
            sentencia.setInt(2, productos.getIdProductos());// id BD existe

            int filasAfectadas = sentencia.executeUpdate();// ejecutando la actualizacion 

            if (filasAfectadas == 0) {
                miRespuesta = "No se encontro precio con este ID";
            }
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en ProductosDAO" + ex.getMessage());

        }
        return miRespuesta;
    }

    public String EliminararPrecios(Productos productos) {

        String miRespuesta;
        miRespuesta = "";

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "DELETE FROM productos WHERE idProductos=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, productos.getIdProductos());// ID a eliminar 

            int filasAfectadas = sentencia.executeUpdate();// ejecutando la actualizacion 

            if (filasAfectadas == 0) {
                miRespuesta = "No se encontro precio con este ID";
            }
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en RolesDAO" + ex.getMessage());

        }
        return miRespuesta;
    }

}
