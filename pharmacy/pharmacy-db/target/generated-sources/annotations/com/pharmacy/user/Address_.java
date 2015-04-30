package com.pharmacy.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<Address, String> address;
	public static volatile SingularAttribute<Address, String> company;
	public static volatile SingularAttribute<Address, String> postCode;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> city;

}

