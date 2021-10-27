/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author toby
 */
public class Note {
    
      String note;
      String date;
    
    public Note() {
    }
    
    public Note(String date, String note) {
        this.date = date;
        this.note = note;
    }

 

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    
    
}
