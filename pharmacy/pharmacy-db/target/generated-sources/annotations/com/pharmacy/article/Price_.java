package com.pharmacy.article;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Price.class)
public abstract class Price_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<Price, Pharmacy> pharmacy;
	public static volatile SingularAttribute<Price, Float> price;
	public static volatile SingularAttribute<Price, String> extraShippingSuffix;
	public static volatile SingularAttribute<Price, Float> suggestedRetailPrice;
	public static volatile SingularAttribute<Price, Integer> discount;

}

