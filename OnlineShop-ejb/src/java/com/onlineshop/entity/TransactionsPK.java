/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author satyam
 */
@Embeddable
public class TransactionsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TRANSACTIONID")
    private String transactionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRODUCTID")
    private String productid;

    public TransactionsPK() {
    }

    public TransactionsPK(String transactionid, String productid) {
        this.transactionid = transactionid;
        this.productid = productid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionid != null ? transactionid.hashCode() : 0);
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionsPK)) {
            return false;
        }
        TransactionsPK other = (TransactionsPK) object;
        if ((this.transactionid == null && other.transactionid != null) || (this.transactionid != null && !this.transactionid.equals(other.transactionid))) {
            return false;
        }
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.TransactionsPK[ transactionid=" + transactionid + ", productid=" + productid + " ]";
    }
    
}
