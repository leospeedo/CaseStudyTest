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
public class PaymentmethodPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMAILID")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "UNIQUEID")
    private String uniqueid;

    public PaymentmethodPK() {
    }

    public PaymentmethodPK(String emailid, String uniqueid) {
        this.emailid = emailid;
        this.uniqueid = uniqueid;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailid != null ? emailid.hashCode() : 0);
        hash += (uniqueid != null ? uniqueid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentmethodPK)) {
            return false;
        }
        PaymentmethodPK other = (PaymentmethodPK) object;
        if ((this.emailid == null && other.emailid != null) || (this.emailid != null && !this.emailid.equals(other.emailid))) {
            return false;
        }
        if ((this.uniqueid == null && other.uniqueid != null) || (this.uniqueid != null && !this.uniqueid.equals(other.uniqueid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.PaymentmethodPK[ emailid=" + emailid + ", uniqueid=" + uniqueid + " ]";
    }
    
}
