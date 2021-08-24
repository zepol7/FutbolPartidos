
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
public class PartidosDAO {
    
    Connection conexion;
    
    public PartidosDAO() throws ClassNotFoundException{
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    
    public List<Equipos> listarEquipos(){
        
        PreparedStatement ps;
        ResultSet rs;        
        List<Equipos> lista = new ArrayList<>();               
        try{
            
            ps = conexion.prepareStatement("SELECT id, nombre FROM equipos");
            rs = ps.executeQuery();                     
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                                
                Equipos equipos = new Equipos(id, nombre);
                
                lista.add(equipos);
            }             
            return lista;
            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return null;            
        }
    }
    
    
    
    public boolean insertarPartidos(Partidos partidos){        
        PreparedStatement ps;        
        try{            
            ps = conexion.prepareStatement("INSERT INTO partidos (usuario, local, visitante, goles_local, goles_visitantes) VALUES(?, ?, ?, ?, ?)");            
            ps.setInt(1, partidos.getUsuario());
            ps.setInt(2, partidos.getLocal());
            ps.setInt(3, partidos.getVisitante());
            ps.setInt(4, partidos.getGoles_local());            
            ps.setInt(5, partidos.getGoles_visitantes());            
            ps.execute();                                             
            return true;            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return false;            
        }
    }
    
    
    public List<VistaPartidos> listarPartidos(){
        
        PreparedStatement ps;
        ResultSet rs;        
        List<VistaPartidos> lista_partidos = new ArrayList<>();               
        try{
            
            ps = conexion.prepareStatement("SELECT p.id, e1.nombre AS local, p.goles_local, e2.nombre AS visitante, p.goles_visitantes " +
                                            "FROM partidos p " +
                                            "INNER JOIN equipos e1 ON e1.id = p.local " +
                                            "INNER JOIN equipos e2 ON e2.id = p.visitante ");
            rs = ps.executeQuery();                     
            while(rs.next()){
                
                int id = rs.getInt("id");
                String local = rs.getString("local");
                String visitante = rs.getString("visitante");
                int goles_local = rs.getInt("goles_local");
                int goles_visitantes = rs.getInt("goles_visitantes");
                
                VistaPartidos vistapartidos = new VistaPartidos(id, local, visitante, goles_local, goles_visitantes);
                
                lista_partidos.add(vistapartidos);
            }             
            return lista_partidos;
            
        }
        catch(SQLException e) {            
            System.out.println(e.toString());            
            return null;            
        }
    }
    
    
    
}
