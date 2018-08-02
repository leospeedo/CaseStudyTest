/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb.impl;

import com.onlineshop.ejb.CustomerDAOLocal;
import com.onlineshop.entity.Cust;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author satyam
 */
@Stateless(mappedName = "onlineshop/ejb/customerDAO")
public class CustomerDAO implements CustomerDAOLocal {
    
    @PersistenceContext(name = "OnlineShop-ejbPU")
    EntityManager entityManager;
    
    @Override
    public boolean addCustomer(Cust customer) {
        entityManager.persist(customer);
        return true;
    }
    
    
    @Override
    public Cust getCustomer(String emailId) {
        Query query=entityManager.createNamedQuery("Cust.findByEmailid", Cust.class);
        query.setParameter("emailid", emailId);
        Cust resultCust=(Cust)query.getSingleResult();
        return resultCust;
    }

    @Override
    public List getAll() {
        Query query=entityManager.createNamedQuery("Customer.findAll",Cust.class);
        return query.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String verifyCustomer(String emailid, String password) {
        Query query=entityManager.createNamedQuery("Cust.findByCredentials", Cust.class);
        query.setParameter("emailid", emailid);
        query.setParameter("password", password);
        try{
            Cust resultCust=(Cust)query.getSingleResult();
            if(resultCust == null){
            return "fail";
        }
        else{
            return "success";
        }
        }catch(Exception e){
            return "fail";
        }
        
    }
}
