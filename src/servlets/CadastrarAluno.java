package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Aluno;
import persistence.AlunoDao;


@WebServlet("/CadastrarAluno")
public class CadastrarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastrarAluno() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		
		Aluno al = new Aluno(cpf, nome, email);
		AlunoDao dao = new AlunoDao();
		
		dao.inserir(al);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
