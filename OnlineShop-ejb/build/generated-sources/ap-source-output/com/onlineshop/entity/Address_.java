package com.onlineshop.entity;

import com.onlineshop.entity.Cust;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-01T23:11:05")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> pincode;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> houseno;
    public static volatile SingularAttribute<Address, Cust> emailid;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, String> addressid;

}