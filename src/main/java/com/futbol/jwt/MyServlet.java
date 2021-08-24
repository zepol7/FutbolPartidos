
package com.futbol.jwt;

import com.futbol.controlador.UsuariosController;
import com.futbol.modelo.Usuarios;
import com.futbol.modelo.UsuariosDAO;
import io.jsonwebtoken.Claims;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USUARIO
 */
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private HashMap<Integer, Usuarios> users = new HashMap<>();

    @Override
    public void init() throws ServletException {
        super.init();
        users.put(Integer.valueOf(1), new Usuarios(1, "Pedro 1", "pedro1@pedro.com", "pedro1", "pedro1"));
        users.put(Integer.valueOf(2), new Usuarios(2, "pedro 2", "pedro2@pedro.com", "pedro2", "pedro2"));
    }

    public MyServlet() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        if (request.getMethod().equals("POST")) {
            doPost(request, response);
        } else {
            doGet(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        //User user=null;
        String username = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[i].getName() + " : " + cookies[i].getValue());
                if (cookies[i].getName().equals("JWT")) {
                    Cookie cookie = cookies[i];
                    try {
                        Claims claims = JWTUtil.parseJWT(cookie.getValue());
                        username = claims.getSubject();
                        System.out.println("name : " + username);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        
        if (username != null) {
            request.setAttribute("username", username);                 
            request.getRequestDispatcher("partidos/listadoUsuarios.jsp").forward(request, response);
        } else {
            System.out.println("SendRedirect");            
            response.sendRedirect("partidos/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        UsuariosDAO usuariosDAO = null;
        try {
            usuariosDAO = new UsuariosDAO();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String account = request.getParameter("text_usuario");
        String password = request.getParameter("text_contrasena");
        
        Usuarios usuario = usuariosDAO.getUsuarios(account, password);
        
        
        System.out.println(account + " : " + password);
        String token = "";
        if (usuario.getId() > 1){
            try {
                    System.out.println(usuario.getNombre());                  
                    
                    token = JWTUtil.createJWT(String.valueOf(usuario.getId()), usuario.getNombre(), 1000 * 60);
                    
                    Cookie cookie = new Cookie("JWT", token);                    
                    cookie.setPath("/");                    
                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }else{
            
            
        }
        
        /*
        System.out.println(account + " : " + password);
        String token = "";
        for (Map.Entry<Integer, Usuarios> item : users.entrySet()) {
            Usuarios u = item.getValue();

            if (u.getUsername().equals(account) && u.getPassword().equals(password)) {
                try {
                    System.out.println(u.getNombre());                  
                    
                    token = JWTUtil.createJWT(String.valueOf(u.getId()), u.getNombre(), 1000 * 60);
                    
                    Cookie cookie = new Cookie("JWT", token);
                    cookie.setPath("/");

                    cookie.setMaxAge(-1);
                    response.addCookie(cookie);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        */
        PrintWriter pw = response.getWriter();
        if (!token.equals("")) {
            System.out.println(token);
            
            pw.print("login succeeded : " + token);
            response.sendRedirect("UsuariosController?accion=lista");
            //request.getRequestDispatcher("UsuariosController?accion=").forward(request, response);
        } else {
            pw.print("login failed : error account or password");
        }
        pw.flush();
        pw.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
