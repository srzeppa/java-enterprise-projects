package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class AddClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		out.println("<html><body><h2>Your data</h2>" +
				"<p>First name: " + request.getParameter("firstname") + "<br />" +
				"<p>Last name: " + request.getParameter("lastname") + "<br />" +
				"<p>Pesel: " + request.getParameter("pesel") + "<br />" +
				"</body></html>");
		out.close();
	}
}