package com.grupoassa.gaservices.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ extends com.grupoassa.gaservices.entities.User_ {

	public static volatile SingularAttribute<Employee, Date> ingressDate;
	public static volatile SingularAttribute<Employee, String> category;
	public static volatile SingularAttribute<Employee, Integer> points;

}

