package Controlador;

import Modelo.PedidoCabecera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PedidoCabeceraDAO {

    public String adicionarPedidoCabecera(PedidoCabecera pedidocabecera) {

        String miRespuesta;
        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "INSERT INTO PedidoCabecera(numeroPedido,fechaPedido,Persona_idPersona)"
                    + "VALUES(?,?,?);";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, pedidocabecera.getNumeroPedido());
            sentencia.setString(2, pedidocabecera.getFechaPedido());
            sentencia.setInt(3, pedidocabecera.getPersona_idPersona());
            sentencia.execute();
            miRespuesta = "";
        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en PedidoCabeceraDAO" + ex.getMessage());

        }
        return miRespuesta;

    }

    public PedidoCabecera ConsultarPedidoCabecera(int numeroPedido) {
        PedidoCabecera pedidocabecera = null;

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "select idPedidoCabecera, numeroPedido, fechaPedido, Persona_idPersona from PedidoCabecera where numeroPedido =" + numeroPedido;
            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                pedidocabecera = new PedidoCabecera();
                pedidocabecera.setIdPedidoCabecera(rs.getInt(1));
                pedidocabecera.setNumeroPedido(rs.getInt(2));
                pedidocabecera.setFechaPedido(rs.getString(3));
                pedidocabecera.setPersona_idPersona(rs.getInt(4));
            }
            return pedidocabecera;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return pedidocabecera;
        }
    }

    public ArrayList<PedidoCabecera> ConsultarPedidoCabecera(String fechaPedido) {
        ArrayList<PedidoCabecera> miListadoPedidosCabecera = new ArrayList<PedidoCabecera>();

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        try {

            Statement sentencia = nuevaCon.createStatement();

            String querySQL = "select idPedidoCabecera, fechaPedido from PedidoCabecera where fechaPedido like '%" + fechaPedido + "%' ORDER BY idPedidoCabecera";

            ResultSet rs = sentencia.executeQuery(querySQL);
            while (rs.next()) {
                PedidoCabecera pedidocabecera = new PedidoCabecera();
                pedidocabecera.setIdPedidoCabecera(rs.getInt(1));
                pedidocabecera.setFechaPedido(rs.getString(2));
                miListadoPedidosCabecera.add(pedidocabecera);
            }
            return miListadoPedidosCabecera;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return miListadoPedidosCabecera;
        }
    }

    public String actualizarPedidoCabecera(PedidoCabecera pedidoCabecera) {
    String miRespuesta = "";
    Conexion miconexion = new Conexion();
    Connection nuevaCon;
    nuevaCon = miconexion.getConn();
    PreparedStatement sentencia;

    try {
        // campos a actualizar (numeroPedido y fechaPedido)
        String Query = "UPDATE pedidocabecera SET numeroPedido=?, fechaPedido=? WHERE idPedidoCabecera=?";
        sentencia = nuevaCon.prepareStatement(Query);

        // Usamos el objeto pedidoCabecera para obtener los valores correctos
        sentencia.setInt(1, pedidoCabecera.getNumeroPedido());  // Número de pedido
        sentencia.setString(2, pedidoCabecera.getFechaPedido());  // Fecha del pedido
        sentencia.setInt(3, pedidoCabecera.getIdPedidoCabecera());  // ID del pedido

        int filasAfectadas = sentencia.executeUpdate(); // Ejecutamos la actualización

        if (filasAfectadas == 0) {
            miRespuesta = "No se encontró un pedido con este ID";
        }

    } catch (Exception ex) {
        miRespuesta = ex.getMessage();
        System.out.println("Ocurrió un error en PedidoCabeceraDAO: " + ex.getMessage());
    }

    return miRespuesta;
}

    public String EliminararPedido(PedidoCabecera pedidocabecera) {

        String miRespuesta;
        miRespuesta = "";

        Conexion miconexion = new Conexion();
        Connection nuevaCon;
        nuevaCon = miconexion.getConn();

        PreparedStatement sentencia;
        try {
            String Query = "DELETE FROM pedidocabecera WHERE numeroPedido=?";
            sentencia = nuevaCon.prepareStatement(Query);
            sentencia.setInt(1, pedidocabecera.getNumeroPedido());// numero a eliminar 

            int filasAfectadas = sentencia.executeUpdate();// ejecutando la actualizacion 

            if (filasAfectadas == 0) {
                miRespuesta = "No se encontro pedido con este numero";
            }
            miRespuesta = "";

        } catch (Exception ex) {
            miRespuesta = ex.getMessage();
            System.out.println("Ocurrio un error en RolesDAO" + ex.getMessage());

        }
        return miRespuesta;
    }
}
