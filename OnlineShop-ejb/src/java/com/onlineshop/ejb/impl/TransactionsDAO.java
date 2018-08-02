/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.ejb.impl;

import javax.ejb.Stateless;
import com.onlineshop.ejb.TransactionsDAOLocal;

/**
 *
 * @author satyam
 */
@Stateless(mappedName = "onlineshop/ejb/transactionsDAO")
public class TransactionsDAO implements TransactionsDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
