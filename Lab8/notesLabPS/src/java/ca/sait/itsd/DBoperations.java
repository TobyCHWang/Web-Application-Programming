/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            String connectionString="jdbc:mysql://localhost:3306/notes";
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
    
    public ArrayList<String> getNotes(){
        
        String sql="select * from notes";
        
        ArrayList<String> noteArrayList=new ArrayList<String>();
        
        
        try {
            Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
             
           noteArrayList.add(rs.getString(2) + "," + rs.getString(3));
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
    public boolean addNotes(String notes){
        boolean result= false;
        String sql="insert into notes set noteText=?;";
        
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
    
    
       //delete notes 
    public boolean deleteNotes(String notes, String date){
        boolean result= false;
        String sql = "delete from notes where noteText =(?) and noteDateTime= (?);  ";
                
        
        try {
            Connection conn=getConnection();
          PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, notes);
            ps.setString(2, date);
            
           
            
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
