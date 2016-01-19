package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;

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
		Object name1 = getServletContext().getAttribute("name1");
		Object name2 = getServletContext().getAttribute("name2");
		Object typ1 = getServletContext().getAttribute("typ1");
		Object typ2 = getServletContext().getAttribute("typ2");
		Object farbe1 = getServletContext().getAttribute("farbe1");
		Object farbe2 = getServletContext().getAttribute("farbe2");

		boolean ki1 = false, ki2 = false;
		if (typ1 == "ki") {
			ki1 = true;
		}
		if (typ1 == "mensch") {
			ki1 = false;
		}
		if (typ2 == "ki") {
			ki2 = true;
		}
		if (typ2 == "mensch") {
			ki2 = false;
		}

		// Spieler player1 = new Spieler(name1,asd,ki1);
		// Spieler player2 = new Spieler(name2,asd, ki2);
		//
		// Spieler spieler[]= getServletContext().getAttribute("spieler1");
		// spiel.setSpieler(Spieler[] player1);
		// String ip = (String) getServletContext().getAttribute("ID");
		// System.out.println(ip);
		// spiel.getSpieler(spieler);

		spiel.add(spiel.getNewSpieler((String) name1, spiel.getFarbEnum(farbe1), ki1));
		spiel.add(spiel.getNewSpieler((String) name2, spiel.getFarbEnum(farbe2), ki2));
		getServletContext().setAttribute("SpielBrett", spiel.getNewSpielbrett());
		
		// Player rotation weiss beginnt
		if (spiel.getSpieler()[0].getFarbe().equals("weiss")) {
			spiel.setActiveSpieler((spiel.getSpieler()[0]));
		} 
		else if (spiel.getSpieler()[1].getFarbe().equals("weiss")) {
			spiel.setActiveSpieler((spiel.getSpieler()[1]));
		}
		getServletContext().getRequestDispatcher("/SpielBrett.jsp").forward(request, response);
		setzeSteine();
			
	}		
	
	// spiel.setActiveSpieler(spiel.getSpieler[0]));


public void setzeSteine() {
SpielBean spiel = (SpielBean) getServletContext().getAttribute("SpielBean");
spiel.getSpielbrett() spielbrett = (spiel.getSpielbrett()) getServletContext().getAttribute("SpielBrett");
	for (int i = spiel.getSpielbrett().getBrett().length - 1; i >= 0; i--) {
		for (int j = 0; j < spiel.getSpielbrett().getBrett()[1].length; j++) {
			if (spiel.getSpielbrett().getBrett()[i][j].getFarbe() == FarbEnum.schwarz) {

				if (spiel.getSpielbrett().getBrett()[i][j].getSpielfigur() != null) {

					if (spiel.getSpielbrett().getBrett()[i][j]
							.getSpielfigur().getFarbe() == FarbEnum.schwarz) {
						if (spiel.getSpielbrett().getBrett()[i][j]
								.getSpielfigur().isDame() == false) {
							ImageIcon icon = new ImageIcon(
									"Dame_Stein_braun_50w.png");
							getServletContext().getRequestDispatcher("/SpielBrett.jsp").forward(request, response);

							//spiel.spielbrett.Brett[j][i].setSpielfigur(FarbEnum.schwarz, false);
						} else {
							ImageIcon icon = new ImageIcon(//image für tabelle erstellen
									"Dame_Dame_braun_50w.png");
							
							
							
							spiel.spielbrett.Brett[j][i].setSpielfigur(FarbEnum.schwarz, true);
						}
					} else {
						if (spiel.getSpielbrett().getBrett()[i][j]
								.getSpielfigur().isDame() == false) {

							ImageIcon icon = new ImageIcon(
									"Dame_Stein_weiss_50.png");
							spiel.spielbrett.Brett[j][i].setSpielfigur(FarbEnum.weiss, false);
						} else {
							ImageIcon icon = new ImageIcon(
									"Dame_Dame_weiss_50.png");
							spiel.spielbrett.Brett[j][i].setSpielfigur(FarbEnum.weiss, true);
						}
					}
				} else {
					spiel.spielbrett.Brett[j][i].setSpielfigur(null);
				}
			}
		}
	}
}

}
