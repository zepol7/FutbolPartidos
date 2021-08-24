package com.futbol.controlador;

import com.futbol.modelo.Equipos;
import com.futbol.modelo.Partidos;
import com.futbol.modelo.PartidosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.futbol.modelo.Usuarios;
import com.futbol.modelo.UsuariosDAO;
import com.futbol.modelo.VistaPartidos;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "UsuariosController", urlPatterns = {"/UsuariosController"})
public class UsuariosController extends HttpServlet {

        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException {
        
        UsuariosDAO usuariosDAO = null;
        try {
            usuariosDAO = new UsuariosDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PartidosDAO partidosDAO = null;
        try {
            partidosDAO = new PartidosDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){            
            dispatcher = request.getRequestDispatcher("partidos/index.jsp");            
            List<Usuarios> listarUsuarios = usuariosDAO.listarUsuarios();
            request.setAttribute("lista", listarUsuarios);
        }
        else if(accion.equals("lista")){
            dispatcher = request.getRequestDispatcher("partidos/listadoUsuarios.jsp");            
            List<Usuarios> listarUsuarios = usuariosDAO.listarUsuarios();
            request.setAttribute("lista", listarUsuarios);
        }
        else if(accion.equals("nuevo")){
            dispatcher = request.getRequestDispatcher("partidos/usuarios.jsp"); 
        }
        else if(accion.equals("insert")){
            
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String username = request.getParameter("username");
            String password = request.getParameter("password");            
            Usuarios usuario = new Usuarios(0, nombre, correo, username, password);            
            usuariosDAO.insertarUsuarios(usuario);                       
            dispatcher = request.getRequestDispatcher("partidos/listadoUsuarios.jsp"); 
            List<Usuarios> listarUsuarios = usuariosDAO.listarUsuarios();
            request.setAttribute("lista", listarUsuarios);            
        }
        else if(accion.equals("modificar")){
            dispatcher = request.getRequestDispatcher("partidos/usuarios_mod.jsp"); 
            int id = Integer.parseInt(request.getParameter("id"));            
            Usuarios usuario = usuariosDAO.mostrarUsuarios(id);
            request.setAttribute("usuario", usuario);
        }
        else if(accion.equals("update")){
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String username = request.getParameter("username");
            String password = request.getParameter("password");            
            Usuarios usuario = new Usuarios(id, nombre, correo, username, password);            
            usuariosDAO.updateUsuarios(usuario);                       
            dispatcher = request.getRequestDispatcher("partidos/listadoUsuarios.jsp"); 
            List<Usuarios> listarUsuarios = usuariosDAO.listarUsuarios();
            request.setAttribute("lista", listarUsuarios);            
        }
        else if(accion.equals("lista_partidos")){
            dispatcher = request.getRequestDispatcher("partidos/partidos.jsp");            
            
            List<Equipos> listarEquipos = partidosDAO.listarEquipos();
            request.setAttribute("lista_equipos", listarEquipos);            
            
            List<VistaPartidos> listarPartidos = partidosDAO.listarPartidos();            
            request.setAttribute("partidos_jugados", listarPartidos);
            
            
            
        }
        else if(accion.equals("insert_partidos")){
            
            
            int equipo_local = Integer.parseInt(request.getParameter("equipo_local"));
            int equipo_visitante = Integer.parseInt(request.getParameter("equipo_visitante"));
            int usuario = 1;
            int gol_local = Integer.parseInt(request.getParameter("gol_local"));
            int gol_visita = Integer.parseInt(request.getParameter("gol_visita"));
            
            Partidos partidos = new Partidos(0, usuario, equipo_local, equipo_visitante, gol_local, gol_visita);
            partidosDAO.insertarPartidos(partidos);
            
            dispatcher = request.getRequestDispatcher("partidos/partidos.jsp"); 
            
            List<VistaPartidos> listarPartidos = partidosDAO.listarPartidos();            
            request.setAttribute("partidos_jugados", listarPartidos);
            
            /*
            Usuarios usuario = new Usuarios(0, nombre, correo, username, password);            
            usuariosDAO.insertarUsuarios(usuario);                       
            dispatcher = request.getRequestDispatcher("partidos/listadoUsuarios.jsp"); 
            List<Usuarios> listarUsuarios = usuariosDAO.listarUsuarios();
            request.setAttribute("lista", listarUsuarios);            
            */
        }
        
        dispatcher.forward(request, response);
        
        

    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
