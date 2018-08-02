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
import com.onlineshop.entity.Prod;
import java.util.ArrayList;

/**
 *
 * @author satyam
 */
@Named(value = "cart")
@SessionScoped
public class CartBean implements Serializable {

    @EJB
    ProductDAOLocal productLocal;

    @EJB
    CartDAOLocal cartLocal;

    private List<String> selectedProductIds;
    private List<Prod> cartProducts;

    public List<Prod> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<Prod> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public void addToCart(String emailId) {
        selectedProductIds.forEach(pid -> {
            int quantity = cartLocal.getQuantityInCart(emailId, pid);
            if (quantity == 0) {
                cartLocal.addProductToCart(new Cart(new CartPK(emailId, pid), 1));
            } else {
                cartLocal.updateProductInCart(new Cart(new CartPK(emailId, pid), quantity + 1));
            }
        });
    }

    public String getProductsInCart(String emailId) {
        List<Cart> cartItems;
        List<String> productIds = new ArrayList<>();
        List<Prod> productList = new ArrayList<>();
        cartItems = cartLocal.getAllProductsForUser(emailId);
        cartItems.forEach(p -> {
            productIds.add(p.getCartPK().getProductid());
            Prod product=productLocal.getProduct(p.getCartPK().getProductid());
            product.setQuantity(p.getQuantity());
            productList.add(product);
        });

//        productIds.forEach((productId) -> {
//            productList.add(productLocal.getProduct(productId));
//        });

        setCartProducts(productList);
        return "success";
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
