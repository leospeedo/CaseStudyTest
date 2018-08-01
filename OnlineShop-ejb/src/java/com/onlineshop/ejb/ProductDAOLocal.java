/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb;

import com.onlineshop.entity.Prod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author satyam
 */
@Local
public interface ProductDAOLocal {
    public boolean addProduct(Prod product);
    public Prod getProduct(String productId);
    public List getAllProducts();
    
}
