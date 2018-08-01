/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author satyam
 */
@Entity
@Table(name = "CUST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cust.findAll", query = "SELECT c FROM Cust c")
    , @NamedQuery(name = "Cust.findByFname", query = "SELECT c FROM Cust c WHERE c.fname = :fname")
    , @NamedQuery(name = "Cust.findByLname", query = "SELECT c FROM Cust c WHERE c.lname = :lname")
    , @NamedQuery(name = "Cust.findByEmailid", query = "SELECT c FROM Cust c WHERE c.emailid = :emailid")
    , @NamedQuery(name = "Cust.findByPassword", query = "SELECT c FROM Cust c WHERE c.password = :password")
    , @NamedQuery(name = "Cust.findByCredentials", query= "SELECT c FROM Cust c WHERE c.emailid=:emailid AND c.password= :password")})
public class Cust implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emailid")
    private List<Address> addressList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cust")
    private List<Paymentmethod> paymentmethodList;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FNAME")
    private String fname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LNAME")
    private String lname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMAILID")
    private String emailid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;

    public Cust() {
    }

    public Cust(String emailid) {
        this.emailid = emailid;
    }

    public Cust(String fname, String lname, String emailid, String password) {
        this.emailid = emailid;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailid != null ? emailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cust)) {
            return false;
        }
        Cust other = (Cust) object;
        if ((this.emailid == null && other.emailid != null) || (this.emailid != null && !this.emailid.equals(other.emailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Cust[ emailid=" + emailid + " ]";
    }

    @XmlTransient
    public List<Paymentmethod> getPaymentmethodList() {
        return paymentmethodList;
    }

    public void setPaymentmethodList(List<Paymentmethod> paymentmethodList) {
        this.paymentmethodList = paymentmethodList;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
    
}
