/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.model;

import com.onlineshop.entity.Cart;
import com.onlineshop.entity.CartPK;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import com.onlineshop.ejb.CartDAOLocal;
import com.onlineshop.ejb.ProductDAOLocal;

/**
 *
 * @author satyam
 */
@Named(value = "cart")
@SessionScoped
public class CartBean implements Serializable {

    /**
     * Creates a new instance of CartBean
     */
    @EJB
    ProductDAOLocal productLocal;

    @EJB
    CartDAOLocal cartLocal;

    private List<String> selectedProductIds;
    private String customerId;

    public void addToCart(String emailId) {
        selectedProductIds.forEach(pid -> {
            int quantity=cartLocal.getQuantityInCart(emailId, pid);
            if ( quantity==0) {
                cartLocal.addProductToCart(new Cart(new CartPK(emailId, pid), 1));
            } else {
                cartLocal.updateProductInCart(new Cart(new CartPK(emailId, pid), quantity+1));
            }
        });
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CartBean(List<String> selectedProducts) {
        this.selectedProductIds = selectedProducts;
    }

    public List<String> getSelectedProductIds() {
        return selectedProductIds;
    }

    public void setSelectedProductIds(List<String> selectedProducts) {
        this.selectedProductIds = selectedProducts;
    }

    public CartBean() {
    }

}
