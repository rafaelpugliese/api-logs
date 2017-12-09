package br.audora.log.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Log.class)
public class Log_ {

	public static volatile SingularAttribute<Log, Long> id;
	public static volatile SingularAttribute<Log, String> produto;
	public static volatile SingularAttribute<Log, String> cliente;
	public static volatile SingularAttribute<Log, String> categoria;
	public static volatile SingularAttribute<Log, Date> dataHora;
	//public static volatile SetAttribute<Log, Map<String, Object>> registros;

}