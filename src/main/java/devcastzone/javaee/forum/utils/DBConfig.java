package devcastzone.javaee.forum.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBConfig implements ServletContextListener {

	private static EntityManagerFactory emf;

	public void contextDestroyed(ServletContextEvent arg0) {
		if (emf != null && emf.isOpen())
			emf.close();
	}

	public void contextInitialized(ServletContextEvent arg0) {
		emf = Persistence.createEntityManagerFactory("Forum");
	}

	public static EntityManager createEntityManager() {
		if (emf != null)
			return emf.createEntityManager();
		else
			return null;
	}

}
