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
@Table(name = "PROD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prod.findAll", query = "SELECT p FROM Prod p")
    , @NamedQuery(name = "Prod.findByProductid", query = "SELECT p FROM Prod p WHERE p.productid = :productid")
    , @NamedQuery(name = "Prod.findByPrice", query = "SELECT p FROM Prod p WHERE p.price = :price")
    , @NamedQuery(name = "Prod.findByCategory", query = "SELECT p FROM Prod p WHERE p.category = :category")
    , @NamedQuery(name = "Prod.findByProductname", query = "SELECT p FROM Prod p WHERE p.productname = :productname")
    , @NamedQuery(name = "Prod.findByQuantity", query = "SELECT p FROM Prod p WHERE p.quantity = :quantity")})
public class Prod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRODUCTID")
    private String productid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CATEGORY")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;

    public Prod() {
    }

    public Prod(String productid) {
        this.productid = productid;
    }

    public Prod(String productid, int price, String category, String productname, int quantity) {
        this.productid = productid;
        this.price = price;
        this.category = category;
        this.productname = productname;
        this.quantity = quantity;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
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
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prod)) {
            return false;
        }
        Prod other = (Prod) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Prod[ productid=" + productid + " ]";
    }
    
}
