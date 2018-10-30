package devcastzone.javaee.forum.serwlety;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devcastzone.javaee.forum.dao.TematyDAO;
import devcastzone.javaee.forum.encje.Temat;

@WebServlet("/index")
public class IndexSerwlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TematyDAO dao = (TematyDAO) request.getAttribute("tematyDAO");
		List<Temat> tematy = dao.pobierzTematy();
		request.setAttribute("tematy", tematy);
		request.getRequestDispatcher("WEB-INF/widok/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
