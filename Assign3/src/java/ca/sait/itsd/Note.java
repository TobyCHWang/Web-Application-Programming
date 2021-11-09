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
public class Note {
        String note;
       String dateTime;
       int noteID;
    
    public Note() {
    }
    
    public Note(String date, String note,int noteID) {
        this.dateTime = date;
        this.note = note;
        this.noteID=noteID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
    
}
