
package Pruebas;

import Controlador.RolesDAO;
import Modelo.Roles;


public class PruebaConsultarRoles {

    public static void main(String[] args) {
        
        RolesDAO rolesDAO = new RolesDAO();
        Roles roles = rolesDAO.consultarRoles(1);
        if (roles != null){
            System.out.println("Dato encontrado "+roles.getDescripcionRol());
        }else{
            System.out.println("Dato no encontrado");
        }
   
    }
    
}
