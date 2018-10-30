package devcastzone.javaee.forum.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import devcastzone.javaee.forum.encje.*;

public class WpisyDAO {

	private EntityManager em;

	public WpisyDAO(EntityManager em) {
		this.em = em;
	}

	public boolean dodajWpis(Wpis w) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(w);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}

	}

}
