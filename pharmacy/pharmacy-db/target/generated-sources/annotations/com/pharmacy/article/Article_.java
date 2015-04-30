package com.pharmacy.article;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Article.class)
public abstract class Article_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<Article, String> categoryName;
	public static volatile SingularAttribute<Article, String> title;
	public static volatile SingularAttribute<Article, String> manufacturer;
	public static volatile SingularAttribute<Article, String> deepLink;
	public static volatile SingularAttribute<Article, String> descriptionLong;
	public static volatile ListAttribute<Article, Price> prices;
	public static volatile SingularAttribute<Article, String> keyWords;
	public static volatile SingularAttribute<Article, Integer> articelNumber;
	public static volatile SingularAttribute<Article, String> descriptionShort;
	public static volatile SingularAttribute<Article, String> imageURL;
	public static volatile SingularAttribute<Article, Currency> currency;

}

