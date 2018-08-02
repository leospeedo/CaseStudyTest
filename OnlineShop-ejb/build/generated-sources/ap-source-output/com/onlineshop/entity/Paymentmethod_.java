package com.onlineshop.entity;

import com.onlineshop.entity.Cust;
import com.onlineshop.entity.PaymentmethodPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-03T00:02:49")
@StaticMetamodel(Paymentmethod.class)
public class Paymentmethod_ { 

    public static volatile SingularAttribute<Paymentmethod, String> mode;
    public static volatile SingularAttribute<Paymentmethod, PaymentmethodPK> paymentmethodPK;
    public static volatile SingularAttribute<Paymentmethod, Cust> cust;

}