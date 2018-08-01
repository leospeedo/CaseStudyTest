/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author satyam
 */
@Entity
@Table(name = "CREDITCARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c")
    , @NamedQuery(name = "Creditcard.findByCardno", query = "SELECT c FROM Creditcard c WHERE c.cardno = :cardno")
    , @NamedQuery(name = "Creditcard.findByCcpassword", query = "SELECT c FROM Creditcard c WHERE c.ccpassword = :ccpassword")
    , @NamedQuery(name = "Creditcard.findByCclimit", query = "SELECT c FROM Creditcard c WHERE c.cclimit = :cclimit")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CARDNO")
    private String cardno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CCPASSWORD")
    private String ccpassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CCLIMIT")
    private int cclimit;

    public Creditcard() {
    }

    public Creditcard(String cardno) {
        this.cardno = cardno;
    }

    public Creditcard(String cardno, String ccpassword, int cclimit) {
        this.cardno = cardno;
        this.ccpassword = ccpassword;
        this.cclimit = cclimit;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCcpassword() {
        return ccpassword;
    }

    public void setCcpassword(String ccpassword) {
        this.ccpassword = ccpassword;
    }

    public int getCclimit() {
        return cclimit;
    }

    public void setCclimit(int cclimit) {
        this.cclimit = cclimit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardno != null ? cardno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditcard)) {
            return false;
        }
        Creditcard other = (Creditcard) object;
        if ((this.cardno == null && other.cardno != null) || (this.cardno != null && !this.cardno.equals(other.cardno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Creditcard[ cardno=" + cardno + " ]";
    }
    
}
