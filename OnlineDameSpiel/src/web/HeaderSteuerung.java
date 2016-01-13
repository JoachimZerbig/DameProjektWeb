package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderSteuerung
 */
@WebServlet("/HeaderSteuerung")
public class HeaderSteuerung extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HeaderSteuerung() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pdfSpeichern = request.getParameter("pdfSpeichern");
		String pdfName = request.getParameter("pdfName");

		String csvSpeichern = request.getParameter("csvSpeichern");
		String serSpeichern = request.getParameter("serSpeichern");
		String csvLaden = request.getParameter("csvLaden");
		String serLaden = request.getParameter("serLaden");

		if (pdfSpeichern != null) {
			getServletContext().getRequestDispatcher("/SpeichernPDF.jsp").forward(request, response);
		}
		if(pdfName.length() <= 3){
			getServletContext().getRequestDispatcher("/SpeichernPDF_FEHLER.jsp").forward(request, response);
		}
	}
}