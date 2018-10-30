package devcastzone.javaee.forum.utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import devcastzone.javaee.forum.dao.TematyDAO;
import devcastzone.javaee.forum.dao.UzytkownicyDAO;
import devcastzone.javaee.forum.dao.WpisyDAO;

@WebListener
public class InicjatorDB implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	public void requestInitialized(ServletRequestEvent arg0) {
		EntityManager em = DBConfig.createEntityManager();

		UzytkownicyDAO uzytkownicyDAO = new UzytkownicyDAO(em);
		TematyDAO tematyDAO = new TematyDAO(em);
		WpisyDAO wpisyDAO = new WpisyDAO(em);
		
		ServletRequest req = arg0.getServletRequest();
		
		req.setAttribute("wpisyDAO", wpisyDAO);
		req.setAttribute("uzytkownicyDAO", uzytkownicyDAO);
		req.setAttribute("tematyDAO", tematyDAO);

	}

}
