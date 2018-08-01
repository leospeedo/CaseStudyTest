package com.onlineshop.entity;

import com.onlineshop.entity.TransactionsPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-01T23:11:05")
@StaticMetamodel(Transactions.class)
public class Transactions_ { 

    public static volatile SingularAttribute<Transactions, Integer> quantity;
    public static volatile SingularAttribute<Transactions, String> emailid;
    public static volatile SingularAttribute<Transactions, Date> time;
    public static volatile SingularAttribute<Transactions, TransactionsPK> transactionsPK;

}