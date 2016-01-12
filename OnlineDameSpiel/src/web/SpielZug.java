package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend.FarbEnum;
import backend.SpielBean;
import backend.Spieler;

import javax.servlet.*;
/**
 * Servlet implementation class SpielZug
 */
@WebServlet("/SpielZug")
public class SpielZug extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpielZug() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("test");
		
		String zug = request.getParameter("zug");
//		System.out.println(zug);
		getServletContext().getRequestDispatcher("/SpielBrett.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(true);
		ServletContext context = ses.getServletContext();
		Object obj = context.getAttribute("SpielBean");
		SpielBean spiel = null;
		if( obj == null){
			spiel = new SpielBean();
			context.setAttribute("SpielBean", spiel);
		}
		else{
//			SpielBean spiel = (SpielBean) context.getAttribute("SpielBean");
			spiel = (SpielBean)obj;
		}
//		Object name = getServletContext().getAttribute("name");
//		Object name2 = getServletContext().getAttribute("name2");
//		Spieler player1 = new Spieler(name, FarbEnum.weiss, ki1);
//		Spieler player2 = new Spieler(name2, FarbEnum.weiss, ki2);
//		
//		Spieler spieler[]= getServletContext().getAttribute("spieler1");
//		spiel.setSpieler(spieler1);
//		String ip = (String) getServletContext().getAttribute("ID");
//		System.out.println(ip);
	}

}
