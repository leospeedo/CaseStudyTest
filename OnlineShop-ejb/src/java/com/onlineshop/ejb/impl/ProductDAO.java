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
@Stateless(mappedName = "onlineshop/ejb/productDAO")
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
        Prod product=new Prod();
        product=(Prod) query.getSingleResult();
        return product;
    }

    @Override
    public List getAllProducts() {
        Query query=entityManager.createNamedQuery("Prod.findAll",Prod.class);
        return query.getResultList();
    }
    
}
