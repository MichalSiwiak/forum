package devcastzone.javaee.forum.serwlety;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devcastzone.javaee.forum.dao.TematyDAO;
import devcastzone.javaee.forum.dao.WpisyDAO;
import devcastzone.javaee.forum.encje.Temat;
import devcastzone.javaee.forum.encje.Uzytkownik;
import devcastzone.javaee.forum.encje.Wpis;

/**
 * Servlet implementation class TematSerwlet
 */
@WebServlet("/temat")
public class TematSerwlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stringId = request.getParameter("id");

		if (stringId != null) {
			int id = Integer.parseInt(stringId);
			TematyDAO dao = (TematyDAO) request.getAttribute("tematyDAO");
			Temat t = dao.pobierzTemat(id);
			request.setAttribute("temat", t);
			request.getRequestDispatcher("WEB-INF/widok/temat.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tresc = request.getParameter("tresc");
		String stringId = request.getParameter("id");

		if (tresc != null && stringId != null) {
			int id = Integer.parseInt(stringId);

			WpisyDAO wpisyDAO = (WpisyDAO) request.getAttribute("wpisyDAO");
			TematyDAO tematyDAO = (TematyDAO) request.getAttribute("tematyDAO");

			Uzytkownik zalogowany = (Uzytkownik) request.getSession().getAttribute("uzytkownik");
			Temat temat = tematyDAO.pobierzTemat(id);
			Wpis wpis = new Wpis();
			wpis.setData(new Timestamp(new Date().getTime()));
			wpis.setTresc(tresc);
			wpis.setTemat(temat);
			wpis.setUzytkownik(zalogowany);
			wpis.setTemat(temat);
			wpisyDAO.dodajWpis(wpis);

		}
		doGet(request, response);

	}

}
