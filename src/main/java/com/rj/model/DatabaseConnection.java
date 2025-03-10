package com.rj.model;

import com.rj.util.ConfigLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    Connection con;
    
    private final String server = ConfigLoader.getProperty("db.server");
    private final String port = ConfigLoader.getProperty("db.port");
    private final String database = ConfigLoader.getProperty("db.database");
    private final String user = ConfigLoader.getProperty("db.user");
    private final String pass = ConfigLoader.getProperty("db.password");
    
    String url = "jdbc:mysql://"+server+":"+port+"/"+database;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            //System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en : "+e);
        }
        return con;
    } 
}
