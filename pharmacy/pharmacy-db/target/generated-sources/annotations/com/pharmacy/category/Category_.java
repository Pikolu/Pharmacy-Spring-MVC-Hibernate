package com.pharmacy.category;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<Category, String> directoryName;
	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, Category> children;

}

