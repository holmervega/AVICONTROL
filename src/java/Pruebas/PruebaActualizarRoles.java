package Pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;
import java.util.Scanner;

public class PruebaActualizarRoles {

    public static void main(String[] args) {

        Scanner dato = new Scanner(System.in);

        RolesDAO misrolesDAO = new RolesDAO();
        Roles misroles = new Roles();

        System.out.println("Por favor digite el ID del rol que desea actualizar");
        int idRoles = dato.nextInt();
        dato.nextLine();
        
        Roles rolExistente = misrolesDAO.ConsultarRoles(idRoles);
        if (rolExistente == null) {
            System.out.println("No se encontró un rol con ese ID.");
            return; // Se detiene el proceso si no existe
        } else {
            System.out.println("Rol encontrado: " + rolExistente.getDescripcionRol());
        }

        System.out.println("Por favor digite el nuevo nombre del rol");
        String descripcionRol = dato.nextLine();

        misroles.setIdRoles(idRoles);
        misroles.setDescripcionRol(descripcionRol);

        String Respuesta = misrolesDAO.ActualizarRoles(misroles);

        if (Respuesta.isEmpty()) {
            System.out.println("El rol se actualizo correctamente");
        } else {
            System.out.println("Error : " + Respuesta);
        }

    }

}
