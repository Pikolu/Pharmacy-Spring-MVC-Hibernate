package com.pharmacy.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserRole.class)
public abstract class UserRole_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<UserRole, Integer> userRoleId;
	public static volatile SingularAttribute<UserRole, String> roleName;
	public static volatile SingularAttribute<UserRole, User> user;

}

