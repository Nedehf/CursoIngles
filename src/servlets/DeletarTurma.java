package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Turma;
import persistence.TurmaDao;

@WebServlet("/DeletarTurma")
public class DeletarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		try{
		String codturma = request.getParameter("codturma");
		TurmaDao dao = new TurmaDao();
		Turma t = dao.buscar(codturma);

		
		dao.remover(codturma, t);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarTurmas");
		rd.forward(request, response);
		} catch (RuntimeException e) {
			response.sendRedirect("Erro.html");
			
			
		}
	
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
