/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineshop.model;

import com.onlineshop.ejb.CustomerDAOLocal;
import com.onlineshop.entity.Cust;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author satyam
 */
@Named(value = "customer")
@SessionScoped
public class CustomerBean implements Serializable {

    /**
     * Creates a new instance of CustomerBean
     */
    @EJB
    CustomerDAOLocal customerDAOLocal;

    private String fname;
    private String lname;
    private String emailid;
    private String password;

    public String registerCustomer() {
        Cust customer = new Cust(fname, lname, emailid, password);
        if (customerDAOLocal.addCustomer(customer)) {
            return "success";
        } else {
            return "fail";
        }
    }

    public String doLogin() {
//        Cust validCust=customerDAOLocal.getCustomer(emailid);
//        Cust testCust=new Cust("","",emailid,password);
//        if(testCust.getEmailid().equals(validCust.getEmailid())&&testCust.getPassword().equals(validCust.getPassword())){
//            return "success";
//        }
//        else{
//            return "fail";
//        }
        return customerDAOLocal.verifyCustomer(emailid, password);
//        if (validCust != null) {
//            return "success";
//        } else {
//            return "fail";
//        }
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerBean() {
    }

}
