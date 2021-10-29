/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
    
<<<<<<< HEAD
    public ArrayList<String> getNotes(){
        
        String sql="select * from notes";
        
        ArrayList<String> noteArrayList=new ArrayList<String>();
=======
    public ArrayList<Note> getNotes(){
        
        String sql="select * from notes";
        
        ArrayList<Note> noteArrayList=new ArrayList<Note>();
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
        
        
        try {
            Connection conn=getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
<<<<<<< HEAD
             
           noteArrayList.add(rs.getString(2) + "," + rs.getString(3));
=======
             Note n=new Note();
            String dateTime = rs.getString("noteDateTime");
            String text = rs.getString("noteText");
            n.setDate(dateTime);
            n.setNote(text);
            noteArrayList.add(n);
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
            }
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return noteArrayList;
    }
    
   
    
    //Add notes 
    public boolean addNotes(String notes){
        boolean result= false;
        String sql="insert into notes set noteText='"+notes+" ' ;";
        
        try {
            Connection conn=getConnection();
            Statement st=conn.createStatement();
            
            int rowAffected = st.executeUpdate(sql);
            
            result=(rowAffected>0);
            
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
<<<<<<< HEAD
       //delete notes 
    public boolean deleteNotes(String notes, String date){
        boolean result= false;
        String sql = "delete from notes where noteText = '"
                + notes + "' and noteDateTime = '" + date + "';";
=======
       //Add notes 
    public boolean deleteNotes(String notes){
        boolean result= false;
        String sql="delete from notes where noteDateTime=' "+notes+" ' ;";
>>>>>>> 89a3b284ca8a30d8802c4684f5b80beeed363c99
        
        try {
            Connection conn=getConnection();
            Statement st=conn.createStatement();
            
            int rowAffected = st.executeUpdate(sql);
            
            result=(rowAffected>0);
            
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
}
