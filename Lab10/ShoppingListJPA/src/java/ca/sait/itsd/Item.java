/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

/**
 *
 * @author toby
 */
public class Item {
     Long item;
     String desc;
     boolean cart;
     
       public Item() {
    }
    
    public Item(Long item, String desc,boolean cart) {
        this.item = item;
        this.desc = desc;
        this.cart=cart;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean getCart() {
        return cart;
    }

    public void setCart(boolean cart) {
        this.cart = cart;
    }
   
     
     
     
}
