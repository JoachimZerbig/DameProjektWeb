package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

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
		
		String pdfServerSpeichern = request.getParameter("pdfServerSpeichern");

		String csvSpeichern = request.getParameter("csvSpeichern");
		String serSpeichern = request.getParameter("serSpeichern");
		String csvLaden = request.getParameter("csvLaden");
		String serLaden = request.getParameter("serLaden");
		
//		getServletContext().setAttribute("pdfName", pdfName);
		
		String filePath = request.getSession().getServletContext().getRealPath("/imageTest.jpg");
//		System.out.println(filePath);
		
//		System.out.println(getServletContext().getAttribute("pdfName"));
		getServletContext().setAttribute("filePath", filePath);
		String pdfName = request.getParameter("pdfName");
		if (pdfSpeichern != null) {

			
			
			 try {
		            Robot robot = new Robot();
		            BufferedImage bi=robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		            ImageIO.write(bi, "jpg", new File(filePath));
		             
		        } catch (AWTException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			 
				
			 getServletContext().setAttribute("pdfName", pdfName);
			 getServletContext().getRequestDispatcher("/SpeichernPDF.jsp").forward(request, response);
				
				
			 }else if(pdfName.length() < 3){
					getServletContext().getRequestDispatcher("/SpeichernPDF_FEHLER.jsp").forward(request, response);
				}
//			 else if(pdfServerSpeichern != null){
//					getServletContext().getRequestDispatcher("/PDFLink.jsp").forward(request, response);
//				}
//		
		 	
		if (pdfServerSpeichern != null) {
			
			com.itextpdf.text.Rectangle pagesize = new com.itextpdf.text.Rectangle(1920, 1080);
			 Document document = new Document(pagesize, 0, 0, 0, 0);

				pdfName = (String) getServletContext().getAttribute("pdfName");
				//System.out.println(pdfName);
				FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/"+pdfName+ ".pdf"));
				PdfWriter writer;
				try {
					writer = PdfWriter.getInstance(document, fos);
					writer.open();
					document.open();
					Image img;
					img = Image.getInstance(filePath);
//					float documentWidth = document.getPageSize().getWidth()
//							- document.leftMargin() - document.rightMargin();
////					float documentHeight = document.getPageSize().getHeight()
//							- document.topMargin() - document.bottomMargin();
//					img.scaleToFit(documentWidth, documentHeight);
					document.add(img);
					document.close();
					writer.close();
					String filePath2 = request.getSession().getServletContext().getRealPath("/"+pdfName+".pdf");
					getServletContext().setAttribute("filePath2", filePath2);
					getServletContext().getRequestDispatcher("/PDFLink.jsp").forward(request, response);
						
				} catch (DocumentException e) {
					e.printStackTrace();
				}
				
			 }

		
		
		
		
		
	}
}