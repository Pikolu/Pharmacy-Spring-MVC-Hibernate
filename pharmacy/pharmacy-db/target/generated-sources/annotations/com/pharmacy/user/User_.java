package com.pharmacy.user;

import com.pharmacy.wishlist.Wishlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<User, String> lastName;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, Address> address;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, Boolean> newslatter;
	public static volatile SingularAttribute<User, Wishlist> wishlist;
	public static volatile SetAttribute<User, UserRole> userRole;
	public static volatile SingularAttribute<User, String> firstName;
	public static volatile SingularAttribute<User, String> password;

}

