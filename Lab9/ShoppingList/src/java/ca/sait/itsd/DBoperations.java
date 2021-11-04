/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.CallableStatement;
import java.sql.Connection;
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
     public ArrayList<Item> getList() {
        ArrayList<Item> itemArrayList=new ArrayList<Item>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select * from listitems where listitemincart=?;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, 0);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                Item i=new Item();
                String id=rs.getString("listitemid");
                String descString=rs.getString(2);
                
               i.setDesc(descString);
               i.setItem(id);
              
               itemArrayList.add(i);
               
            }
            
            rs.close();
            ps.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return itemArrayList;
    }
     
     
     public ArrayList<Item> getCartList() {
        ArrayList<Item> itemArrayList=new ArrayList<Item>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            String sql = "select * from listitems where listitemincart=?;";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ResultSet rs=ps.executeQuery();
            
            while (rs.next()) {
                Item i=new Item();
                String id=rs.getString("listitemid");
                String descString=rs.getString(2);
                
               i.setDesc(descString);
               i.setItem(id);
              
               itemArrayList.add(i);
               
            }
            
            rs.close();
            ps.close();
            cp.freeConnection(conn);
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return itemArrayList;
    }
     
     
    public boolean addList(String list) {
        boolean result = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "call addListItem(?);";
        
        try {
              Connection conn = cp.getConnection();
            CallableStatement st = conn.prepareCall(sql);
            
            st.setString(1,list);  // ';drop database users1;#
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            cp.freeConnection(conn); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
    
      public boolean deleteItem(String item) {
        boolean result = false;
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "call deleteListItem(?);";
        
        try {
             Connection conn = cp.getConnection();
            CallableStatement st = conn.prepareCall(sql);
            
            st.setString(1,item);
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
            cp.freeConnection(conn); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
      
      public boolean updateCart(String list) {
        boolean result = false;
         ConnectionPool cp = ConnectionPool.getInstance();
        
        String sql = "call toggleInCart(?)";
        
        try {
            Connection conn = cp.getConnection();
            CallableStatement st = conn.prepareCall(sql);
            
            st.setString(1,list);
            
            int rowAffected = st.executeUpdate();
            
            result = (rowAffected>0);
            
            st.close();
           cp.freeConnection(conn);  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return result;
    }
    
}
