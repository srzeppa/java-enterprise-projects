package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class Questionaire extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		/*Simple information handling*/
		if(request.getParameter("rate").equals("5")){
			
		out.println("<html><body><h2>Ankieta</h2>" +
				"<p>Prosimy o wypelnienie nastepujacej ankiety:</p>" +
				"<p>Plec: " + request.getParameter("sex") + "<br />" +
				"<p>Ocena: " + request.getParameter("rate") + "<br /> Dziękujemy <br />" +
				"<p>Informacje dodatkowe: " + request.getParameter("info") + "<br />" +
				"</body></html>");
		out.close();
		}
		out.println("<html><body><h2>Add client</h2>" +
				"<p>Plec: " + request.getParameter("sex") + "<br />" +
				"<p>Ocena: " + request.getParameter("rate") + "<br />" +
				"<p>Informacje dodatkowe: " + request.getParameter("info") + "<br />" +
				"</body></html>");
		out.close();
		
	}

}
