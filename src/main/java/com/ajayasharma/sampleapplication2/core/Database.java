/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajayasharma.sampleapplication2.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private PreparedStatement statement;
    private ResultSet resultSet;
    
    Database(){
        this.dbDriver = "org.gjt.mm.mysql.Driver";
        this.dbUrl = "jdbc:mysql://localhost/testdb";
        this.dbUser = "root";
        this.dbPassword = "mysql";
        
    }
    
    public void connect() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(this.dbDriver);
            this.connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPassword);
        }
        catch( ClassNotFoundException | SQLException ex ){
            throw ex;
        }
    }
    
    public void getStatement(String query) {
        
    }
    
}
