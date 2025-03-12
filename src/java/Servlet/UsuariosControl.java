package Servlet;

import Controlador.PersonaDAO;
import Controlador.UsuariosDAO;
import Modelo.Persona;
import Modelo.Usuarios;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsuariosControl", urlPatterns = {"/UsuariosControl"})
public class UsuariosControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Servlet UsuariosControl se ejecutó");

        // Instancia del DAO
        UsuariosDAO usuariosDAO = new UsuariosDAO();

        // Obtener la lista de usuarios desde la BD
        List<Usuarios> listaUsuarios = usuariosDAO.ObtenerTodosLosUsuarios();
       

        // Verificar si la lista realmente tiene datos antes de enviarla
        System.out.println("Lista de usuarios en el Servlet: " + listaUsuarios.size());

        // Enviar la lista a la vista (usuarios.jsp)
        // Enviar la lista a la sesión en lugar de la request
        request.setAttribute("listaUsuarios", listaUsuarios);
       
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aquí podrías manejar acciones como agregar, editar o eliminar usuarios
    }

    @Override
    public String getServletInfo() {
        return "Controlador para la gestión de usuarios";
    }
}
