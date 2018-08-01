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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author satyam
 */
@Entity
@Table(name = "CART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c")
    , @NamedQuery(name = "Cart.findByCustomerid", query = "SELECT c FROM Cart c WHERE c.cartPK.customerid = :customerid")
    , @NamedQuery(name = "Cart.findByProductid", query = "SELECT c FROM Cart c WHERE c.cartPK.productid = :productid")
    , @NamedQuery(name = "Cart.findByQuantity", query = "SELECT c FROM Cart c WHERE c.quantity = :quantity")
    , @NamedQuery(name ="Cart.findProductInCart",query="SELECT c FROM Cart c where c.cartPK.customerid= :customerid AND c.cartPK.productid= :productid")})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CartPK cartPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;

    public Cart() {
    }

    public Cart(CartPK cartPK) {
        this.cartPK = cartPK;
    }

    public Cart(CartPK cartPK, int quantity) {
        this.cartPK = cartPK;
        this.quantity = quantity;
    }

    public Cart(String customerid, String productid) {
        this.cartPK = new CartPK(customerid, productid);
    }

    public CartPK getCartPK() {
        return cartPK;
    }

    public void setCartPK(CartPK cartPK) {
        this.cartPK = cartPK;
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
        hash += (cartPK != null ? cartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.cartPK == null && other.cartPK != null) || (this.cartPK != null && !this.cartPK.equals(other.cartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlineshop.entity.Cart[ cartPK=" + cartPK + " ]";
    }
    
}
