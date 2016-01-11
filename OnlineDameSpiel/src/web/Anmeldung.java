package web;

import java.io.IOException;
import java.net.InetAddress;

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

		//Wenn Spiel bereits vorhanden
		if(getServletContext().getAttribute("spiel")== null){
		SpielBean spiel = new SpielBean();
		String name = request.getParameter("spname");
		String farbe = request.getParameter("farbe");
		String typ = request.getParameter("typ");
		String abschicken = request.getParameter("abschicken");
		
		
		
		if (name == null && farbe == null && typ == null) {
			getServletContext().getRequestDispatcher("/FormularSpiel.jsp").forward(request, response);
		} 
		else if(name.length() < 3 || farbe == null || typ == null){
			getServletContext().getRequestDispatcher("/FormularFehler.jsp").forward(request, response);
		}
		if(name.length() >= 3 && farbe != null && typ != null && abschicken != null) {
			Spieler spieler1 = new Spieler(name);
			String sessionID;
			
			//IP-Adresse
			InetAddress ip = InetAddress.getLocalHost ();
			String ipAdress = ip.getHostAddress();
			getServletContext().setAttribute("ID", ipAdress);
			getServletContext().setAttribute("spieler1",spieler1);
			getServletContext().setAttribute("spiel",spiel);
			
	
			HttpSession session = request.getSession();
			request.getSession(true);
			sessionID = session.getId();

			session.setAttribute("spiel", spiel);
			session.setAttribute("spieler", spieler1);

			getServletContext().getRequestDispatcher("/SpielBrett.jsp").forward(request, response);
		}	
		}
		else if(getServletContext().getAttribute("spiel")!= null){
			SpielBean spiel = (SpielBean) getServletContext().getAttribute("spiel");
			Spieler spieler1 = (Spieler) getServletContext().getAttribute("spieler1");
			String farbe1 = request.getParameter("farbe");

			//Überprüfung Farbe Spieler1 
			if(spieler1){
			getServletContext().getRequestDispatcher("/FormularSpiel2s.jsp").forward(request, response);
			}
			
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