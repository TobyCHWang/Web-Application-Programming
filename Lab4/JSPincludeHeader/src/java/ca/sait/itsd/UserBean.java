/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.Serializable;

/**
 *
 * @author toby
 */
public class UserBean implements Serializable{
       String username;
    
    
    public UserBean() {
    }
    
    public UserBean(String name) {
        this.username = name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String name) {
        this.username=name;
    }   
}

