/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.tp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brother
 */
public class ConexionManager {
    public static final String DB = "bd_taller_mecanico";
    public static final String URL = "jdbc:postgresql://localhost:5432/"+DB;
    public static final String USER = "brother";
    public static final String PASSWORD = "brother";
    
    public static Connection conexion;
    public static Statement stm;
    public static PreparedStatement pstm;
    
    public static void conectar(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            stm = conexion.createStatement();
             System.out.println("conectado base de datos "+ DB +" user: "+USER);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  static void desconectar(){
        if (conexion != null) {
            try {
                conexion.close();
                stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
