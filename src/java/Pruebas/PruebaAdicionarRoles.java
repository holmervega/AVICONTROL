package Pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;
import java.util.Scanner;

public class PruebaAdicionarRoles {

    public static void main(String[] args) {

        RolesDAO misrolesDAO = new RolesDAO();
        Roles misroles = new Roles();

        Scanner dato = new Scanner(System.in);

        String descripcionRol = "";
        System.out.println("Por favor digite su rol");
        descripcionRol = dato.next();
        misroles.setDescripcionRol(descripcionRol);
        String respuesta = misrolesDAO.AdicionarRoles(misroles);
        if (respuesta.length() == 0) {
            System.out.println("Rol registrado con exito");
        } else {
            System.out.println("Error al registrar el Rol" + respuesta);
        }
    }

}
