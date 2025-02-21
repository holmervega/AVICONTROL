package Pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;
import static java.lang.System.out;
import java.util.ArrayList;

public class PruebaListarRoles {

    public static void main(String[] args) {

        RolesDAO rolesDAO = new RolesDAO();

        ArrayList<Roles> listarroles;

        listarroles = rolesDAO.ConsultarListaRoles("");

        int size = listarroles.size();
        System.out.println("<tabe border=\"1\")><br><td>idRoles>/td><td>descripcionRol</td>");

        for (Roles p : listarroles) {
            out.println("<tr>");
            out.println("<td>" + p.getIdRoles() + "</td");
            out.println("<td>" + p.getDescripcionRol() + "</td");
            out.println("<tr>");
        }
        System.out.println("</table");

    }

}
