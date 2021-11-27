/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author toby
 */
public class DBoperations {
    
    //get
    public ArrayList<User> getUser() {
        ArrayList<User> userArrayList=new ArrayList<User>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select * from users;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                User u=new User();
                String type="";
                String lock="";
              
                String userString=rs.getString("username");
                String passwordString=rs.getString("password");
                String typeString=rs.getString("usertype");
                String lockedString=rs.getString("locked");
                 if (lockedString.equals("0")) {
                    lock="Unlocked";
                }else if (lockedString.equals("1")) {
                    lock="Locked";
                }
               
                if (typeString.equals("0")) {
                    type="Normal";
                }else if (typeString.equals("1")) {
                    type="Admin";
                }
     
                 
                
               u.setUsername(userString);
               u.setPassword(passwordString);
               u.setUsertype(type);
               u.setLocked(lock);
              
               userArrayList.add(u);
               
            }
            
            rs.close();
            ps.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return userArrayList;
    }
    
    //add
    public boolean addUsername(String username, String password) {
        boolean result = false;
        ConnectionPool cp = ConnectionPool.getInstance();

        String sql = "insert into users set username=?, password=?;";

        try {
            Connection conn = cp.getConnection();

            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, password);

            int rowAffected = st.executeUpdate();

            result = (rowAffected > 0);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }
    
    //update
     //Update username
    public boolean updateUsername(String username, String newUsername) {
        boolean result = false;
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "update users set username=? where username=?;";
        
        try {
            Connection conn=cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1,newUsername);
            st.setString(2, username);
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
    public boolean toggleUsernameType(String Username) {
       
        boolean result = false;
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "update users set usertype=(not usertype) where username=?;";
        
        try {
            Connection conn=cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1,Username);
            
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    public boolean toggleUsernameTypeOnly(String Username) {
       
        boolean result = false;
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "update users set usertype=(not usertype) where username=? and usertype=(?);";
        
        try {
            Connection conn=cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1,Username);
            st.setInt(2, 0);
            
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
    public boolean toggleUsernameLocked(String Username) {
       
        boolean result = false;
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "update users set locked=(not locked) where username=?;";
        
        try {
            Connection conn=cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1,Username);
            
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
    
    
    
    
     public int getAdminCount() {
       int count=0;
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select COUNT(*) FROM users where usertype=(?) ;";
            PreparedStatement ps=conn.prepareStatement(sql);
            
             ps.setInt(1,1);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                   count=rs.getInt(1);
                }
                
            
            rs.close();
            ps.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return count;
    }
     
     public int getNormalCount() {
       int count=0;
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select COUNT(*) FROM users where usertype=(?) ;";
            PreparedStatement ps=conn.prepareStatement(sql);
            
             ps.setInt(1,0);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                   count=rs.getInt(1);
                }
                
            
            rs.close();
            ps.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return count;
    }
     
     
     public int getUnlockAdminCount() {
       int count=0;
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select COUNT(*) FROM users where usertype=(?) and locked=(?) ;";
            PreparedStatement ps=conn.prepareStatement(sql);
            
             ps.setInt(1,1);
             ps.setInt(2,0);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                   count=rs.getInt(1);
                }
                
            
            rs.close();
            ps.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return count;
    }
     
     
      public boolean deleteUsername(String username) {
        boolean result = false;
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "delete from users where username=(?);";
        
        try {
            Connection conn=cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            
            st.setString(1, username);
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            conn.close(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
}
