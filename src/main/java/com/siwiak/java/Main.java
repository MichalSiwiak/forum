package com.siwiak.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee =new Employee();
		Employee employee2 =new Employee();
		
		//employee.setId(1);
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(5000);
		
		employee2.setFirstName("Ola");
		employee2.setLastName("Toporowska");
		employee2.setSalary(60000);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
