/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author satyam
 */
@Entity
@Table(name = "TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTransactionid", query = "SELECT t FROM Transactions t WHERE t.transactionsPK.transactionid = :transactionid")
    , @NamedQuery(name = "Transactions.findByProductid", query = "SELECT t FROM Transactions t WHERE t.transactionsPK.productid = :productid")
    , @NamedQuery(name = "Transactions.findByEmailid", query = "SELECT t FROM Transactions t WHERE t.emailid = :emailid")
    , @NamedQuery(name = "Transactions.findByTime", query = "SELECT t FROM Transactions t WHERE t.time = :time")
    , @NamedQuery(name = "Transactions.findByQuantity", query = "SELECT t FROM Transactions t WHERE t.quantity = :quantity")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TransactionsPK transactionsPK;
    @Size(max = 20)
    @Column(name = "EMAILID")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;

    public Transactions() {
    }

    public Transactions(TransactionsPK transactionsPK) {
        this.transactionsPK = transactionsPK;
    }

    public Transactions(TransactionsPK transactionsPK, Date time, int quantity) {
        this.transactionsPK = transactionsPK;
        this.time = time;
        this.quantity = quantity;
    }

    public Transactions(String transactionid, String productid) {
        this.transactionsPK = new TransactionsPK(transactionid, productid);
    }

    public TransactionsPK getTransactionsPK() {
        return transactionsPK;
    }

    public void setTransactionsPK(TransactionsPK transactionsPK) {
        this.transactionsPK = transactionsPK;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionsPK != null ? transactionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionsPK == null && other.transactionsPK != null) || (this.transactionsPK != null && !this.transactionsPK.equals(other.transactionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Transactions[ transactionsPK=" + transactionsPK + " ]";
    }
    
}
