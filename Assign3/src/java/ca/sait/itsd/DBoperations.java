/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author toby
 */
public class DBoperations {
    
    private Connection getConnection(){
        Connection conn=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString="jdbc:mysql://localhost:3306/assign3db";
            String username="root";
            String password="password";
            
            conn=DriverManager.getConnection(connectionString, username, password);
                    
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
        return conn;
    }
    
    //Return usernaem from database
    
    public String getUser(){
        
        String sql="select username from users;";
        String result="";
       
        
        
        try {
            Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           
            
            while (rs.next()) {
             
           result=result+rs.getString(1)+",";
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
     public String getPassword(String username){
        
        String sql="select password from users where username=(?);";
        String result="";
       
        
        
        try {
            Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
           
            
            while (rs.next()) {
             
           result=result+rs.getString(1);
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
  
    public boolean addUser(String userString,String passwordString){
        boolean result= false;
        String sql="INSERT INTO users (username,password) VALUES (?,?)";
        
        try {
            Connection conn=getConnection();
           PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, userString);
            ps.setString(2, passwordString);
            
            int rowAffected = ps.executeUpdate();
            
            result=(rowAffected>0);
            
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
    //note
     public ArrayList<Note> getNotes(String username){
        
        String sql="select * from notes where FK_username=(?)";
        
        ArrayList<Note> noteArrayList=new ArrayList<Note>();
        
        
        try {
            Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
             Note n=new Note();
            String dateTime = rs.getString("noteDateTime");
            String text = rs.getString("note");
            int idString=rs.getInt("noteID");
            n.setDateTime(dateTime);
            n.setNote(text);
            n.setNoteID(idString);
            noteArrayList.add(n);
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return noteArrayList;
    }
     
       //Add notes 
    public boolean addNotes(String note,String username){
        boolean result= false;
        String sql="INSERT INTO notes (FK_username,note) VALUES (?,?)";
        
        try {
           Connection conn=getConnection();
           PreparedStatement ps=conn.prepareStatement(sql);
           
            ps.setString(1, username);
            ps.setString(2, note);
            
            int rowAffected = ps.executeUpdate();
            
            result=(rowAffected>0);
            
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    public boolean deleteNotes(String notes){
        boolean result= false;
        String sql="delete from notes where noteID=(?);";
        
        try {
            Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, notes);
            
            int rowAffected = ps.executeUpdate();
            
            result=(rowAffected>0);
            
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
      
    
}
