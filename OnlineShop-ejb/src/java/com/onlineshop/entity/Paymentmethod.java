/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PAYMENTMETHOD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentmethod.findAll", query = "SELECT p FROM Paymentmethod p")
    , @NamedQuery(name = "Paymentmethod.findByEmailid", query = "SELECT p FROM Paymentmethod p WHERE p.paymentmethodPK.emailid = :emailid")
    , @NamedQuery(name = "Paymentmethod.findByMode", query = "SELECT p FROM Paymentmethod p WHERE p.mode = :mode")
    , @NamedQuery(name = "Paymentmethod.findByUniqueid", query = "SELECT p FROM Paymentmethod p WHERE p.paymentmethodPK.uniqueid = :uniqueid")})
public class Paymentmethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaymentmethodPK paymentmethodPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MODE")
    private String mode;
    @JoinColumn(name = "EMAILID", referencedColumnName = "EMAILID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cust cust;

    public Paymentmethod() {
    }

    public Paymentmethod(PaymentmethodPK paymentmethodPK) {
        this.paymentmethodPK = paymentmethodPK;
    }

    public Paymentmethod(PaymentmethodPK paymentmethodPK, String mode) {
        this.paymentmethodPK = paymentmethodPK;
        this.mode = mode;
    }

    public Paymentmethod(String emailid, String uniqueid) {
        this.paymentmethodPK = new PaymentmethodPK(emailid, uniqueid);
    }

    public PaymentmethodPK getPaymentmethodPK() {
        return paymentmethodPK;
    }

    public void setPaymentmethodPK(PaymentmethodPK paymentmethodPK) {
        this.paymentmethodPK = paymentmethodPK;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Cust getCust() {
        return cust;
    }

    public void setCust(Cust cust) {
        this.cust = cust;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentmethodPK != null ? paymentmethodPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentmethod)) {
            return false;
        }
        Paymentmethod other = (Paymentmethod) object;
        if ((this.paymentmethodPK == null && other.paymentmethodPK != null) || (this.paymentmethodPK != null && !this.paymentmethodPK.equals(other.paymentmethodPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Paymentmethod[ paymentmethodPK=" + paymentmethodPK + " ]";
    }
    
}
