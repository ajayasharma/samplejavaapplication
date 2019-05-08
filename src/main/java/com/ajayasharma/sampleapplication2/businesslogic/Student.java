/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajayasharma.sampleapplication2.businesslogic;

import com.ajayasharma.sampleapplication2.core.Database;
import com.ajayasharma.sampleapplication2.entities.StudentEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author AjayaSharma
 */
public class Student {
    private StudentEntity student;
    private Database database;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public Student() throws ClassNotFoundException, SQLException {
        try {
            this.database = new Database();
            this.connection = this.database.connect();
        }
        catch( ClassNotFoundException ex) {
            throw ex;
        }
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
    
    public boolean store() throws SQLException {
        try {
            String query = "INSERT INTO student (firstName, lastName, courseName) VALUES ( ?, ?, ?)";
            
            preparedStatement = this.connection.prepareStatement(query);
            
            preparedStatement.setString(1, this.student.getFirstName());
            preparedStatement.setString(2, this.student.getLastName());
            preparedStatement.setString(3, this.student.getCourseName());
            
            preparedStatement.execute();
            return true;
        }
        catch(SQLException ex) {
            throw ex;
        }
        finally {
            preparedStatement.close();
        }
    }
    
    public boolean update() throws SQLException {
        try {
            String query = "UPDATE student SET firstName=? , lastName=? , courseName=? WHERE id=?";
            
            preparedStatement = this.connection.prepareStatement(query);
            
            preparedStatement.setString(1, this.student.getFirstName());
            preparedStatement.setString(2, this.student.getLastName());
            preparedStatement.setString(3, this.student.getCourseName());
            preparedStatement.setInt(4, this.student.getId());
            
            preparedStatement.execute();
            return true;
        }
        catch(SQLException ex) {
            throw ex;
        }
        finally {
            preparedStatement.close();
        }
    }
    
    public boolean delete() throws SQLException {
        try {
            String query = "DELETE FROM student WHERE id=?";
            
            preparedStatement = this.connection.prepareStatement(query);
            
            preparedStatement.setInt(1, this.student.getId());
            
            preparedStatement.execute();
            return true;
        }
        catch(SQLException ex) {
            throw ex;
        }
        finally {
            preparedStatement.close();
        }
    }
    
    public ArrayList<StudentEntity> listAll() throws SQLException {
        try {
            ArrayList<StudentEntity> students = new ArrayList<>();
            
            String query = "SELECT * FROM student";
            
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()) {
                StudentEntity s = new StudentEntity();
                s.setId(this.resultSet.getInt("id"));
                s.setFirstName(this.resultSet.getString("firstName"));
                s.setLastName(this.resultSet.getString("lastName"));
                s.setCourseName(this.resultSet.getString("courseName"));
                students.add(s);
            }
            return students;
        }
        catch(SQLException ex){
            throw ex;
        }
    }
    
    public StudentEntity load(int id) throws SQLException {
        try {
            String query = "SELECT * FROM student WHERE id=" + id;
            
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(query);
            while(this.resultSet.next()) {
                StudentEntity s = new StudentEntity();
                s.setId(this.resultSet.getInt("id"));
                s.setFirstName(this.resultSet.getString("firstName"));
                s.setLastName(this.resultSet.getString("lastName"));
                s.setCourseName(this.resultSet.getString("courseName"));
                return s;
            }
            return null;
        }
        catch(SQLException ex){
            throw ex;
        }
    }
    
}
