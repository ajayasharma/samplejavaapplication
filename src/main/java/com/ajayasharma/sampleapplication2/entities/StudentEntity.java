/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajayasharma.sampleapplication2.entities;

/**
 *
 * @author AjayaSharma
 */
public class StudentEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String courseName;
    
    public void StudentEntity(){
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.courseName="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
}
