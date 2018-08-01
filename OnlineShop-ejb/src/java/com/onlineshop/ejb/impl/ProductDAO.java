/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb.impl;

import com.onlineshop.entity.Prod;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.onlineshop.ejb.ProductDAOLocal;

/**
 *
 * @author satyam
 */
@Stateless
public class ProductDAO implements ProductDAOLocal {

    @PersistenceContext(name = "OnlineShop-ejbPU")
    EntityManager entityManager;
    
    @Override
    public boolean addProduct(Prod product) {
        entityManager.persist(product);
        return true;
    }

    @Override
    public Prod getProduct(String productId) {
        Query query=entityManager.createNamedQuery("Prod.findByProductid", Prod.class);
        query.setParameter("productid", productId);
        return (Prod)query.getSingleResult();
    }

    @Override
    public List getAllProducts() {
        Query query=entityManager.createNamedQuery("Prod.findAll",Prod.class);
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
