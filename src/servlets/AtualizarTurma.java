package servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Turma;
import persistence.TurmaDao;

@WebServlet("/AtualizarTurma")
public class AtualizarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AtualizarTurma() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cod = request.getParameter("codigo");
		String lvl = request.getParameter("nivel");
		String prof = request.getParameter("professor");
		String hr = request.getParameter("horario");
		String sala = request.getParameter("sala");
		int qtde = Integer.parseInt(request.getParameter("quantidade"));
		String sts = request.getParameter("status");

		System.out.println(cod);
		System.out.println(lvl);
		System.out.println(prof);
		System.out.println(hr);
		System.out.println(sala);
		System.out.println(qtde);
		System.out.println(sts);

		TurmaDao tdao = new TurmaDao();

		Turma t = new Turma(cod, lvl, prof, hr, sala, qtde, sts);

		tdao.alterar(t);

		RequestDispatcher rd = request.getRequestDispatcher("ListarTurmas");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
