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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author toby
 */
public class DBoperations {
     public ArrayList<Item> getList() {
        ArrayList<Item> itemArrayList=new ArrayList<Item>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        Query item = em.createNamedQuery("Listitems.findByListitemincart", Listitems.class).setParameter("listitemincart", false);
        
        List<Listitems> itemList;
        
        try {
            itemList = item.getResultList();
            
            for (Listitems i:  itemList) {
               Item item1=new  Item();
               item1.setDesc(i.getListitemdesc());
               item1.setItem(i.getListitemid());
               item1.setCart(i.getListitemincart());
               itemArrayList.add(item1);
            }
        }
        finally {
            em.close();
        }
        
        
        return itemArrayList;
    }
     
     
     public ArrayList<Item> getCartList() {
         ArrayList<Item> itemArrayList=new ArrayList<Item>();
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        Query item = em.createNamedQuery("Listitems.findByListitemincart", Listitems.class).setParameter("listitemincart", true);
        
        List<Listitems> itemList;
        
        try {
            itemList = item.getResultList();
            
            for (Listitems i:  itemList) {
               Item item1=new  Item();
               item1.setDesc(i.getListitemdesc());
               item1.setItem(i.getListitemid());
                item1.setCart(i.getListitemincart());
               itemArrayList.add(item1);
            }
        }
        finally {
            em.close();
        }
        
        
        return itemArrayList;
    }
     
     
    public boolean addList(String list) {
           boolean result=false;
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        int i=0;
        long l=i;
        try {
            trans.begin();
            em.persist(new Listitems(l, list,false));
            trans.commit();
            result=true;
        }
        catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();
        }
        finally {
            em.close();
        }

        return result;
    }
    
    
      public boolean deleteItem(Long item) {
          boolean result=false;
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            
            Listitems items = (Listitems) em.createNamedQuery("Listitems.findByListitemid").setParameter("listitemid", item).getSingleResult();
            
            em.remove(items);
            
            trans.commit();
            result=true;
        }
        catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();
        }
        finally {
            em.close();
        }

        return result;
    }
      
      public boolean updateCart(Long list,boolean status) {
          boolean result=false;
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            
            Listitems items = (Listitems) em.createNamedQuery("Listitems.findByListitemid").setParameter("listitemid", list).getSingleResult();
            
           items.setListitemincart(!status);
            
            trans.commit();
            result=true;
        }
        catch (Exception ex) {
            trans.rollback();
            ex.printStackTrace();
        }
        finally {
            em.close();
        }

        return result;
    
}
}
