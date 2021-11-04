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
     String item;
     String desc;
     String cart;
     
       public Item() {
    }
    
    public Item(String item, String desc,String cart) {
        this.item = item;
        this.desc = desc;
        this.cart=cart;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
   
     
     
     
}
