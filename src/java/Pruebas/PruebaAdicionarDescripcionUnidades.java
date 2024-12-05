package Pruebas;

import Controlador.UnidadesDAO;
import Modelo.Unidades;
import java.util.Scanner;

public class PruebaAdicionarDescripcionUnidades {

    public static void main(String[] args) {

        UnidadesDAO misunidadesDAO = new UnidadesDAO();
        Unidades misunidades = new Unidades();

        Scanner dato = new Scanner(System.in);

        String descripcionUnidades = "";
        System.out.println("Por favor digite la descripcion de producto");
        descripcionUnidades = dato.next();
        misunidades.setDescripcionUnidades(descripcionUnidades);
        String respuesta = misunidadesDAO.adicionarDescripcionUnidades(misunidades);
        if (respuesta.length() == 0) {
            System.out.println("Descripcion registrado con exito");
        } else {
            System.out.println("Error al registrar la descripcion" + respuesta);
        }
    }

}


