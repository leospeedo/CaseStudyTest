package com.onlineshop.entity;

import com.onlineshop.entity.Address;
import com.onlineshop.entity.Paymentmethod;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-03T00:02:49")
@StaticMetamodel(Cust.class)
public class Cust_ { 

    public static volatile SingularAttribute<Cust, String> fname;
    public static volatile SingularAttribute<Cust, String> lname;
    public static volatile SingularAttribute<Cust, String> password;
    public static volatile ListAttribute<Cust, Paymentmethod> paymentmethodList;
    public static volatile ListAttribute<Cust, Address> addressList;
    public static volatile SingularAttribute<Cust, String> emailid;

}