package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/questionaire")
public class QuestionaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	
		/*Printing simple form and "sending" it to second servlet*/
		out.println("<html><body><h2>Survey</h2>" +
				"<form action='data'>" +
				"Sex: <br /> <input type='radio' name='sex' id='male' value='Male'>" +
				"<label for='male'>Male</label>" +
				"<input type='radio' name='sex' id='male' value='Female'>" +
				"<label for='female'>Female</label> <br /> <br />" +
				"In scale from 1 (terrible) to 5 (great) tell us what do you think about your last visit in our cybercafe <br /> <br />" +
				"<input type='radio' name='rate' id='1' value='1'> <input type='radio' name='rate' id='2' value='2'> <input type='radio' name='rate' id='3' value='3'> <input type='radio' name='rate' id='4' value='4'> <input type='radio' name='rate' id='5' value='5'>" +
				"<br />  <br /> <textarea name='info' rows='4' cols='50'></textarea>" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();
		
	}

}
