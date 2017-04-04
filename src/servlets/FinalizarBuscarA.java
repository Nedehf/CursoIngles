package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Matricula;
import persistence.MatriculaDao;


@WebServlet("/FinalizarBuscarA")
public class FinalizarBuscarA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		double nota = Double.parseDouble(request.getParameter("nota"));
		double freq = Double.parseDouble(request.getParameter("freq"));
		String cpf = request.getParameter("cpf");
		String codturma = request.getParameter("codigo");
		
		Matricula matr = new Matricula(cpf, codturma, null,nota, freq);
		MatriculaDao mdao = new MatriculaDao();
		mdao.alterar(cpf, codturma, matr);
	
	
		RequestDispatcher rd = request.getRequestDispatcher("PrepararBuscarA");
		rd.forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
