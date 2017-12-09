package br.audora.log.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Log.class)
public class Log_ {

	public static volatile SingularAttribute<Log, Long> id;
	public static volatile SingularAttribute<Log, String> product;
	public static volatile SingularAttribute<Log, String> client;
	public static volatile SingularAttribute<Log, String> category;
	public static volatile SingularAttribute<Log, Date> dateHour;

}