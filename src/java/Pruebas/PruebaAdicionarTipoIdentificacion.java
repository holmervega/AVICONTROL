
package Pruebas;

import Controlador.TipoIdentificacionDAO;
import Modelo.TipoIdentificacion;
import java.util.Scanner;

public class PruebaAdicionarTipoIdentificacion {

   
    public static void main(String[] args) {
        
        TipoIdentificacionDAO mistipoidentificacionDAO = new TipoIdentificacionDAO();
        TipoIdentificacion mistipoidentificaion = new TipoIdentificacion();

        Scanner dato = new Scanner(System.in);

        String descripcionTipoIdentificacion = "";
        System.out.println("Por favor digite su tipo de identificacion");
       descripcionTipoIdentificacion = dato.next();
        mistipoidentificaion.setDescripcionTipoIdentificacion(descripcionTipoIdentificacion);
        String respuesta = mistipoidentificacionDAO.adicionarTipoIdentificacion(mistipoidentificaion);
        if (respuesta.length() == 0) {
            System.out.println("Tripo identificacion registrado con exito");
        } else {
            System.out.println("Error al registrar el tipo de identificaion" + respuesta);
        }
    }   

    }
    

