/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajayasharma.sampleapplication2.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AjayaSharma
 */
public class Database{
    private String dbDriver;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private Connection connection;
    
    public Database(){
        this.dbDriver = "org.gjt.mm.mysql.Driver";
        this.dbUrl = "jdbc:mysql://localhost/testdb";
        this.dbUser = "root";
        this.dbPassword = "mysql";
    }
    
    public Connection connect() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(this.dbDriver);
            this.connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
            return this.connection;
        }
        catch( ClassNotFoundException | SQLException ex ){
            throw ex;
        }
    }
    
    public void disconnect() throws SQLException {
        this.connection.close();
        
    }
}
