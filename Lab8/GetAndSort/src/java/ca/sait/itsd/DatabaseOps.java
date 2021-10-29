/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author toby
 */
public class DatabaseOps {
    
    private Connection getConnection(){
        Connection conn=null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString="jdbc:mysql://localhost:3306/users1";
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
    
    public String getAscendingUsernames(){
        
        String sql="select * from users order by username ASC";
        
        String result="";
        
        try {
            Connection conn=getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
               result=result+rs.getString(1)+",";
            }
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public String getDescendingUsernames(){
        
        String sql="select * from users order by username DESC";
        
        String result="";
        
        try {
            Connection conn=getConnection();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
            while (rs.next()) {
               result=result+rs.getString(1)+",";
            }
            
            rs.close();
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    
}
