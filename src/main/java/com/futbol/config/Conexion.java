
package com.futbol.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    private String servidor;
    private int puerto;
    private String usuario;
    private String contrasena;
    private String baseDatos;
    protected Connection con;
    
    public Conexion() {
        servidor = "localhost";
        puerto = 3306;
        usuario = "root";
        contrasena = "antares1";
        baseDatos = "futbol";
    }
    
    
    public Connection getConexion() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");            
            Connection Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/futbol", "root", "antares1");            
            System.out.println("Conexión Existosa");
            
            return Conexion;
        }
        catch (SQLException e){
            System.out.println(e.toString());
            return null;
        }
        
        
    }
    
}
