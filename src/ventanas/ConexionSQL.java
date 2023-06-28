/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Paola Mejia
 */
public class ConexionSQL {
    //Metodo de conexion
    public static Connection getConnection(){
    
    //Cadena de conexion
        String conexionURL = "jdbc:sqlserver://localhost:50082;" +
            "databaseName=Koa_Info;" +
            "user=sa;" +
            "password=yupiyolo123;" +
            "encrypt=true;trustServerCertificate=true";
        
    //Devuelve la conexion
    try{
        Connection conn = DriverManager.getConnection(conexionURL);
        return conn;
    }
    catch(SQLException ex){
        System.out.println("ERROR En la conexion: " + ex.toString());
        return null;
    }   
    }   
}
