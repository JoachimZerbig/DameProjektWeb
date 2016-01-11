package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.*;

/**
 * Servlet implementation class Anmeldung
 */
@WebServlet("/Anmeldung")
public class Anmeldung extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Anmeldung() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);

		SpielBean spiel = new SpielBean();
		String name = request.getParameter("spname");
		String farbe = request.getParameter("farbe");
		String typ = request.getParameter("typ");

		if (name == null && farbe == null && typ == null) {
			getServletContext().getRequestDispatcher("/FormularSpiel.jsp").forward(request, response);
		} 
		else if(name.length() < 3 || farbe == null || typ == null){
			getServletContext().getRequestDispatcher("/FormularFehler.jsp").forward(request, response);
		}
		if(name.length() >= 3 && farbe != null && typ != null) {
			Spieler spieler = new Spieler(name);
			spiel.setActiveSpieler(spieler);
			HttpSession session = request.getSession();
			String sessionID;
			request.getSession(true);
			sessionID = session.getId();

			session.setAttribute("spiel", spiel);
			session.setAttribute("spieler", spieler);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// String neuesSpiel = request.getParameter("neuesSpiel");
		// String spielBeitreten = request.getParameter("spielBeitreten");
		// if (neuesSpiel != null) {
		// response.sendRedirect("FormularSpiel.jsp");
		// }
		// String abschicken = request.getParameter("abschicken");
		// String name = request.getParameter("spname");
		// String farbe = request.getParameter("farbe");
		// String typ = request.getParameter("typ");
		// if (abschicken != null) {
		// if(name.length() < 3 || farbe == null || typ == null){
		// response.sendRedirect("FormularFehler.jsp");
		// }
		// }
		//
		// else if (spielBeitreten != null) {
		// response.sendRedirect("FormularSpiel.jsp");
		// }
	}
}