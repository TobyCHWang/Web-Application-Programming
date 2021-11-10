/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author toby
 */
@Entity
@Table(name = "listitems", catalog = "shoppinglist", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Listitems.findAll", query = "SELECT l FROM Listitems l"),
    @NamedQuery(name = "Listitems.findByListitemid", query = "SELECT l FROM Listitems l WHERE l.listitemid = :listitemid"),
    @NamedQuery(name = "Listitems.findByListitemdesc", query = "SELECT l FROM Listitems l WHERE l.listitemdesc = :listitemdesc"),
    @NamedQuery(name = "Listitems.findByListitemincart", query = "SELECT l FROM Listitems l WHERE l.listitemincart = :listitemincart")})
public class Listitems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "listitemid")
    private Long listitemid;
    @Basic(optional = false)
    @Column(name = "listitemdesc")
    private String listitemdesc;
    @Basic(optional = false)
    @Column(name = "listitemincart")
    private boolean listitemincart;

    public Listitems() {
    }

    public Listitems(Long listitemid) {
        this.listitemid = listitemid;
    }

    public Listitems(Long listitemid, String listitemdesc, boolean listitemincart) {
        this.listitemid = listitemid;
        this.listitemdesc = listitemdesc;
        this.listitemincart = listitemincart;
    }

    public Long getListitemid() {
        return listitemid;
    }

    public void setListitemid(Long listitemid) {
        this.listitemid = listitemid;
    }

    public String getListitemdesc() {
        return listitemdesc;
    }

    public void setListitemdesc(String listitemdesc) {
        this.listitemdesc = listitemdesc;
    }

    public boolean getListitemincart() {
        return listitemincart;
    }

    public void setListitemincart(boolean listitemincart) {
        this.listitemincart = listitemincart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listitemid != null ? listitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listitems)) {
            return false;
        }
        Listitems other = (Listitems) object;
        if ((this.listitemid == null && other.listitemid != null) || (this.listitemid != null && !this.listitemid.equals(other.listitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ca.sait.itsd.Listitems[ listitemid=" + listitemid + " ]";
    }
    
}
