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
@Table(name = "DEBITCARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Debitcard.findAll", query = "SELECT d FROM Debitcard d")
    , @NamedQuery(name = "Debitcard.findByAccountno", query = "SELECT d FROM Debitcard d WHERE d.accountno = :accountno")
    , @NamedQuery(name = "Debitcard.findByDcnumber", query = "SELECT d FROM Debitcard d WHERE d.dcnumber = :dcnumber")
    , @NamedQuery(name = "Debitcard.findByNbpassword", query = "SELECT d FROM Debitcard d WHERE d.nbpassword = :nbpassword")
    , @NamedQuery(name = "Debitcard.findByDcpassword", query = "SELECT d FROM Debitcard d WHERE d.dcpassword = :dcpassword")
    , @NamedQuery(name = "Debitcard.findByBalance", query = "SELECT d FROM Debitcard d WHERE d.balance = :balance")})
public class Debitcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ACCOUNTNO")
    private String accountno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DCNUMBER")
    private String dcnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NBPASSWORD")
    private String nbpassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DCPASSWORD")
    private String dcpassword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private int balance;

    public Debitcard() {
    }

    public Debitcard(String accountno) {
        this.accountno = accountno;
    }

    public Debitcard(String accountno, String dcnumber, String nbpassword, String dcpassword, int balance) {
        this.accountno = accountno;
        this.dcnumber = dcnumber;
        this.nbpassword = nbpassword;
        this.dcpassword = dcpassword;
        this.balance = balance;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getDcnumber() {
        return dcnumber;
    }

    public void setDcnumber(String dcnumber) {
        this.dcnumber = dcnumber;
    }

    public String getNbpassword() {
        return nbpassword;
    }

    public void setNbpassword(String nbpassword) {
        this.nbpassword = nbpassword;
    }

    public String getDcpassword() {
        return dcpassword;
    }

    public void setDcpassword(String dcpassword) {
        this.dcpassword = dcpassword;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountno != null ? accountno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Debitcard)) {
            return false;
        }
        Debitcard other = (Debitcard) object;
        if ((this.accountno == null && other.accountno != null) || (this.accountno != null && !this.accountno.equals(other.accountno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Debitcard[ accountno=" + accountno + " ]";
    }
    
}
