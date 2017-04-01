package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Aluno;
import persistence.AlunoDao;

/**
 * Servlet implementation class BuscarAluno
 */
@WebServlet("/BuscarAluno")
public class BuscarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoDao dao = new AlunoDao();
		
		List<Aluno> alunos = dao.mostrar();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<select name='cpfAluno'>");
		for (Aluno aluno : alunos) {
			out.println("<option value='"+aluno.getCpf()+"'>"+aluno.getNome()+"</option>");
		}
		out.println("</select>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
