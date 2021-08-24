
package com.futbol.modelo;

import com.futbol.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class UsuariosDAO {
    
    Connection conexion;
    
    public UsuariosDAO() throws ClassNotFoundException{
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Usuarios> listarUsuarios(){
        
        PreparedStatement ps;
        ResultSet rs;        
        List<Usuarios> lista = new ArrayList<>();               
        try{
            
            ps = conexion.prepareStatement("SELECT id, nombre, correo, username, password FROM usuarios");
            rs = ps.executeQuery();                     
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                Usuarios usuarios = new Usuarios(id, nombre, correo, username, password);
                
                lista.add(usuarios);
            }             
            return lista;
            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return null;            
        }
    }
    
    
    public Usuarios mostrarUsuarios(int _id){
        
        PreparedStatement ps;
        ResultSet rs;        
        Usuarios usuarios = null;
        try{
            
            ps = conexion.prepareStatement("SELECT u.id, u.nombre, u.correo, u.username, u.password FROM usuarios u where u.id=?");
            
            ps.setInt(1, _id);
            
            rs = ps.executeQuery();                     
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                usuarios = new Usuarios(id, nombre, correo, username, password);
                
                
            }             
            return usuarios;
            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return null;            
        }
    }
    
    
    public boolean insertarUsuarios(Usuarios usuarios){        
        PreparedStatement ps;        
        try{            
            ps = conexion.prepareStatement("INSERT INTO usuarios (nombre, correo, username, password) VALUES(?, ?, ?, ?)");            
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getCorreo());
            ps.setString(3, usuarios.getUsername());
            ps.setString(4, usuarios.getPassword());            
            ps.execute();                                             
            return true;            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return false;            
        }
    }
    
    
    public boolean updateUsuarios(Usuarios usuarios){        
        PreparedStatement ps;        
        try{            
            ps = conexion.prepareStatement("UPDATE usuarios SET nombre=?, correo=?, username=?, password=? WHERE id = ?");            
            ps.setString(1, usuarios.getNombre());
            ps.setString(2, usuarios.getCorreo());
            ps.setString(3, usuarios.getUsername());
            ps.setString(4, usuarios.getPassword());
            ps.setInt(5, usuarios.getId());            
            ps.execute();                                             
            return true;            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return false;            
        }
    }
    
    
    public boolean deleteUsuarios(int _id){        
        PreparedStatement ps;        
        try{            
            ps = conexion.prepareStatement("DELETE FROM usuarios WHERE id = ?");            
          
            ps.setInt(1, _id);            
            ps.execute();                                             
            return true;            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return false;            
        }
    }
    
    
    
    public Usuarios getUsuarios(String Usuario, String Contrasena){
        
        PreparedStatement ps;
        ResultSet rs;        
        Usuarios usuarios = null;
        try{
            
            ps = conexion.prepareStatement("SELECT u.id, u.nombre, u.correo, u.username, u.password FROM usuarios u where u.username=? AND u.password=?");
            
            ps.setString(1, Usuario);
            ps.setString(2, Contrasena);
            
            rs = ps.executeQuery();                     
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                usuarios = new Usuarios(id, nombre, correo, username, password);
                
                
            }             
            return usuarios;
            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return null;            
        }
    }
    
}
