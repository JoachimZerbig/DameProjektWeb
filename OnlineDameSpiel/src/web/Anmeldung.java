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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
//		if (getServletContext().getAttribute("spiel") != null) {

			// Wenn Spiel noch nicht vorhanden
			if (getServletContext().getAttribute("spiel") == null) {
				SpielBean spiel = new SpielBean();
				String name1 = request.getParameter("spname");
				String farbe1 = request.getParameter("farbe");
				String typ1 = request.getParameter("typ");
				String abschicken = request.getParameter("abschicken");

				if (name1 == null && farbe1 == null && typ1 == null) {
					getServletContext().getRequestDispatcher("/FormularSpiel.jsp").forward(request, response);
				} else if (name1.length() < 3 || farbe1 == null || typ1 == null) {
					getServletContext().getRequestDispatcher("/FormularFehler.jsp").forward(request, response);
				}
//				System.out.println(name1 + farbe1 + typ1);
				if (name1.length() >= 3 && farbe1 != null && typ1 != null && abschicken != null) {
					Spieler spieler1;
					
					InetAddress ip = InetAddress.getLocalHost();
					String ipAdress = ip.getHostAddress();
					getServletContext().setAttribute("name1", name1);
					getServletContext().setAttribute("ID", ipAdress);				
					getServletContext().setAttribute("spiel", spiel);
					getServletContext().setAttribute("farbe1", farbe1);
					getServletContext().setAttribute("typ1", typ1);
					
					if(getServletContext().getAttribute(farbe1).equals("schwarz")){
						if(getServletContext().getAttribute(typ1).equals("ki")){
							spieler1 = new Spieler(name1, FarbEnum.schwarz, true);
							getServletContext().setAttribute("spieler1", spieler1);
						}
						else if(getServletContext().getAttribute(typ1).equals("mensch")){
							spieler1 = new Spieler(name1, FarbEnum.schwarz, false);
							getServletContext().setAttribute("spieler1", spieler1);
						}
					}
					else if(getServletContext().getAttribute(farbe1).equals("weiss")){
						if(getServletContext().getAttribute(typ1).equals("ki")){
							spieler1 = new Spieler(name1, FarbEnum.weiss, true);
							getServletContext().setAttribute("spieler1", spieler1);
						}
						else if(getServletContext().getAttribute(typ1).equals("mensch")){
							spieler1 = new Spieler(name1, FarbEnum.weiss, false);
							getServletContext().setAttribute("spieler1", spieler1);
						}
					}

			}
			else {
				if(getServletContext().getAttribute("farbe1").equals("schwarz")){
					getServletContext().getRequestDispatcher("/FormularSpiel2w.jsp").forward(request, response);
				}
				else if(getServletContext().getAttribute("farbe1").equals("weiss")){
				getServletContext().getRequestDispatcher("/FormularSpiel2s.jsp").forward(request, response);
				}
			}
			}
		}
		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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