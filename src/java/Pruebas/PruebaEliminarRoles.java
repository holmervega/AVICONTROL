package Pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;
import java.util.ArrayList;

public class PruebaEliminarRoles {

    public static void main(String[] args) {

        RolesDAO misrolesDAO = new RolesDAO();
     //   Roles misroles = new Roles();
        
        //consultar en el listado si exixte el rol que vamos a eleminar 
        ArrayList<Roles>ConsultarListaRoles = misrolesDAO.ConsultarListaRoles("");
        if (ConsultarListaRoles.isEmpty()){
            System.out.println("No hay marcas registrdas");
            return;
        }
         Roles eliminarRoles = ConsultarListaRoles.get(0);
         System.out.println("Marca eliminada: " + eliminarRoles.getDescripcionRol());
         
         String respuesta = misrolesDAO.EliminararRoles(eliminarRoles);
         
         if (respuesta.isEmpty()){
             System.out.println("Marca eliminada exitosamente");
         
         }else {
             System.out.println("Error al eliminar la marca" + respuesta);
         }
        
    }

}
