/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb;

import com.onlineshop.entity.Cart;
import com.onlineshop.entity.Prod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author satyam
 */
@Local
public interface CartDAOLocal {
    public boolean addProductToCart(Cart productInCart);
    public boolean updateProductInCart(Cart productInCart);
    public int getQuantityInCart(String emailId, String productId);
    public List getAll();
}
