/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajayasharma.sampleapplication2;
import java.sql.*;
/**
 *
 * @author AjayaSharma
 */
import java.sql.Connection;
import java.util.Calendar;
public class SampleClass {
    
    public void sampleSelect() {
        try
        {
          // create our mysql database connection
          String myDriver = "org.gjt.mm.mysql.Driver";
          String myUrl = "jdbc:mysql://localhost/test";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          // our SQL SELECT query. 
          // if you only need a few columns, specify them by name instead of using "*"
          String query = "SELECT * FROM users";

          // create the java statement
          Statement st = conn.createStatement();

          // execute the query, and get a java resultset
          ResultSet rs = st.executeQuery(query);

          // iterate through the java resultset
          while (rs.next())
          {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            Date dateCreated = rs.getDate("date_created");
            boolean isAdmin = rs.getBoolean("is_admin");
            int numPoints = rs.getInt("num_points");

            // print the results
            System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
          }
          st.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
    }
    
    public void sampleInsert() {
        try
        {
          // create a mysql database connection
          String myDriver = "org.gjt.mm.mysql.Driver";
          String myUrl = "jdbc:mysql://localhost/test";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "root", "");

          // create a sql date object so we can use it in our INSERT statement
          Calendar calendar = Calendar.getInstance();
          java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

          // the mysql insert statement
          String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
            + " values (?, ?, ?, ?, ?)";

          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString (1, "Barney");
          preparedStmt.setString (2, "Rubble");
          preparedStmt.setDate   (3, startDate);
          preparedStmt.setBoolean(4, false);
          preparedStmt.setInt    (5, 5000);

          // execute the preparedstatement
          preparedStmt.execute();

          conn.close();
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
        
    }
    
    
    
}
