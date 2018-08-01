/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb.impl;

import com.onlineshop.entity.Cart;
import com.onlineshop.entity.Prod;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.onlineshop.ejb.CartDAOLocal;

/**
 *
 * @author satyam
 */
@Stateless
public class CartDAO implements CartDAOLocal {

    @PersistenceContext(name = "OnlineShop-ejbPU")
    EntityManager entityManager;

    @Override
    public boolean addProductToCart(Cart productInCart) {
        entityManager.persist(productInCart);
        return true;
    }

    @Override
    public List getAll() {
        Query query = entityManager.createNamedQuery("Cart.findAll", CartDAO.class);
        return query.getResultList();
    }

    @Override
    public boolean updateProductInCart(Cart productInCart) {
        entityManager.merge(productInCart);
        return true;
    }

    @Override
    public int getQuantityInCart(String emailId, String productId) {
        Query query=entityManager.createNamedQuery("Cart.findProductInCart", Cart.class);
        query.setParameter("customerid", emailId);
        query.setParameter("productid", productId);
        try{
            Cart productInCart=(Cart)query.getSingleResult();
            return productInCart.getQuantity();
        } catch(Exception e){
            return 0;
        }
    }
}
