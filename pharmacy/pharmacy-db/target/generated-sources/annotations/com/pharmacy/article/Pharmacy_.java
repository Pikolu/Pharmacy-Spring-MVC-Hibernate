package com.pharmacy.article;

import com.pharmacy.csv.CSVFormat;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.payment.PaymentType;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pharmacy.class)
public abstract class Pharmacy_ extends com.pharmacy.base.BaseUUID_ {

	public static volatile SingularAttribute<Pharmacy, String> logoURL;
	public static volatile SingularAttribute<Pharmacy, Float> shipping;
	public static volatile SingularAttribute<Pharmacy, Price> price;
	public static volatile ListAttribute<Pharmacy, CSVFormat> csvFormat;
	public static volatile SingularAttribute<Pharmacy, String> name;
	public static volatile ListAttribute<Pharmacy, Evaluation> evaluations;
	public static volatile CollectionAttribute<Pharmacy, PaymentType> paymentTypes;

}

