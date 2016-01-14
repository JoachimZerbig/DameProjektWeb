package web;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.FarbEnum;
import backend.SpielBean;
import backend.Spieler;

/**
 * Servlet implementation class AnmeldungPl2
 */
@WebServlet("/AnmeldungPl2")
public class AnmeldungPl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnmeldungPl2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (getServletContext().getAttribute("spiel") != null) {
			String name2 = request.getParameter("spname");
			String farbe2 = request.getParameter("farbe");
			String typ2 = request.getParameter("typ");
			String abschicken = request.getParameter("abschicken");
			
			if (name2.length() >= 3 && farbe2 != null && typ2 != null && abschicken != null) {
			
				getServletContext().setAttribute("name2", name2);
				getServletContext().setAttribute("farbe2", farbe2);
				getServletContext().setAttribute("typ2", typ2);				
			
			Spieler spieler2;
			if(getServletContext().getAttribute(farbe2).equals("schwarz")){
				if(getServletContext().getAttribute(typ2).equals("ki")){
					spieler2 = new Spieler(name2, FarbEnum.schwarz, true);
					getServletContext().setAttribute("spieler2", spieler2);
				}
				else if(getServletContext().getAttribute(typ2).equals("mensch")){
					spieler2 = new Spieler(name2, FarbEnum.schwarz, false);
					getServletContext().setAttribute("spieler2", spieler2);
				}
			}
			else if(getServletContext().getAttribute(farbe2).equals("weiss")){
				if(getServletContext().getAttribute(typ2).equals("ki")){
					spieler2 = new Spieler(name2, FarbEnum.weiss, true);
					getServletContext().setAttribute("spieler1", spieler2);
				}
				else if(getServletContext().getAttribute(typ2).equals("mensch")){
					spieler2 = new Spieler(name2, FarbEnum.weiss, false);
					getServletContext().setAttribute("spieler1", spieler2);
				}
			}
			} 
			getServletContext().getRequestDispatcher("/SpielBrett.jsp").forward(request, response);
			//SpielBean spiel = (SpielBean) getServletContext().getAttribute("spiel");
			
			//String farbe1 = (String) getServletContext().getAttribute("farbe1");
		
			
			
			getServletContext().setAttribute("name2", name2);
			//getServletContext().setAttribute("spieler2", spieler2);
			//getServletContext().setAttribute("spiel", spiel);
			getServletContext().setAttribute("farbe2", farbe2);
			getServletContext().setAttribute("typ2", farbe2);
			//System.out.println(farbe2);
			getServletContext().getRequestDispatcher("/SpielBrett.jsp").forward(request, response);
			

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
