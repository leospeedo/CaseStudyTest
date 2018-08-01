/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb;

import com.onlineshop.entity.Cust;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author satyam
 */
@Local
public interface CustomerDAOLocal {
    public boolean addCustomer(Cust customer);
    public String verifyCustomer(String emailid, String password);
    public Cust getCustomer(String emailId);
    public List getAll();
}
