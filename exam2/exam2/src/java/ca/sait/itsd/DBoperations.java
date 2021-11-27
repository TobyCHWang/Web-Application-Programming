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
            String connectionString="jdbc:mysql://localhost:3306/contacts";
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
    
    public ArrayList<Contact> getContact(){
        
        String sql="select * from contacts";
        
        ArrayList<Contact> contactArrayList=new ArrayList<Contact>();
        
        
        try {
            Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
             Contact contact=new Contact ();
             String nameString=rs.getString("contactName");
             String id=rs.getString("contactID");
             String cityString=rs.getString("contactCity");
            contact.setId(id);
            contact.setCity(cityString);
            contact.setName(nameString);
             
             contactArrayList.add(contact);
            }
            
            rs.close();
            ps.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return contactArrayList;
    }
    
    
   public boolean addContact(String name,String city){
        boolean result= false;
        String sql="INSERT INTO contacts (contactName,contactCity) VALUES (?,?);";
        
        try {
            Connection conn=getConnection();
           PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, city);
            
            int rowAffected = ps.executeUpdate();
            
            result=(rowAffected>0);
            
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
   
   
    public boolean deleteContact(String id){
        boolean result= false;
        String sql = "delete from contacts where contactID= (?);  ";
                
        
        try {
            Connection conn=getConnection();
          PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            
            
           
            
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
