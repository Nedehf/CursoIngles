package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CadastrarTurma")
public class CadastrarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastrarTurma() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("codigo");
		String lvl = request.getParameter("nivel");
		String prof = request.getParameter("professor");
		String hr = request.getParameter("horario");
		String sala = request.getParameter("sala");
		String qtde = request.getParameter("Message");
		String sts = request.getParameter("status");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Codigo: "+cod+"<br/>");
		out.println("Nivel: "+lvl+"<br/>");
		out.println("Professor: "+prof+"<br/>");
		out.println("Horario: "+hr+"<br/>");
		out.println("Sala: "+sala+"<br/>");
		out.println("Quantidade Maxima: "+qtde+"<br/>");
		out.println("Status: "+sts+"<br/>");
		out.println("</body></html>");
		out.close();
		

	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
