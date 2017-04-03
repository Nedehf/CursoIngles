package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Matricula;
import persistence.MatriculaDao;

@WebServlet("/MatricularAluno")
public class MatricularAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MatricularAluno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = request.getParameter("Aluno");
		String cod = request.getParameter("Turma");
		Date date = new Date();

//		AlunoDao adao = new AlunoDao();
//		Aluno al = adao.buscarAluno(cpf);
//		
//		TurmaDao tdao = new TurmaDao();
//		Turma t = tdao.buscar(cod);

		MatriculaDao mdao = new MatriculaDao();
		Matricula m = new Matricula(cpf,cod,date,0,1);
		
		mdao.inserir(m);
		
//		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("PreparaMatricula");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
