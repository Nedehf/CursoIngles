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
import beans.Turma;
import persistence.TurmaDao;

import beans.Aluno;
import persistence.AlunoDao;

@WebServlet("/MatricularAluno")
public class MatricularAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MatricularAluno() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		TurmaDao tdao = new TurmaDao();
		List<Turma> turmas = tdao.mostrar();

		AlunoDao adao = new AlunoDao();

		List<Aluno> alunos = adao.mostrar();

		PrintWriter out = response.getWriter();

		out.println("<html>" + "<head>" + "<meta charset='ISO-8859-1'>" + "<title>Matricular Aluno</title>"
				+ "<link rel='stylesheet' href='https://www.w3schools.com/w3css/3/w3.css'>" + "<link rel='stylesheet'"
				+ "	href='https://fonts.googleapis.com/css?family=Montserrat'>" + "<link rel='stylesheet'"
				+ "	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>" +

				"<title>Efetuar Matrícula</title>" + "</head>");

		out.println("<style>" + "body, h1, h2, h3, h4, h5, h6 {" + "	font-family: 'Montserrat', sans-serif" + "}" +

				"h3 {" + "	color: white;" + "}" +

				"input[type='radio'] {" + "	margin: 0 10px 0 10px;" + "}" +

				".w3-row-padding img {" + "	margin-bottom: 12px" + "}" +

				"/* Set the width of the sidebar to 120px */" + ".w3-sidebar {" + "	width: 120px;"
				+ "	background: #222;" + "}" +

				"/* Add a left margin to the 'page content' that matches the width of the sidebar (120px) */"
				+ "#main {" + "	margin-left: 120px" + "}" +

				"/* Remove margins from 'page content' on small screens */"
				+ "@media only screen and (max-width: 600px) {" + "	#main {" + "		margin-left: 0" + "	}" + "}" +

				".bgimg {" + "	background-position: center;" + "	background-repeat: no-repeat;"
				+ "	background-size: cover;" + "	background-image: url('Resources\\BG_01.jpg');"
				+ "	min-height: 100%;" + "}" + "</style>");

		out.println("<body class='w3-black'>" +

				"<nav class='w3-sidebar w3-hide-medium w3-hide-small' style='width: 30%'>"
				+ "	<div class='bgimg'></div>" + "</nav>");

		out.println("<!-- Page Content -->" + "<div class='w3-main w3-padding-large' style='margin-left: 29%'>" +

				"	<div class='w3-padding-64 w3-content w3-text-grey' id='cadastro'"
				+ "		style='margin-bottom: 64px'>" + "		<h2 class='w3-text-light-grey'>Efetuar Matrícula</h2>"
				+ "		<hr style='width: 200px' class='w3-opacity'>" +

				"		<!-- Campos -->" + "		<p>Selecione o aluno e a turma a ser matriculado:</p>" +

				"		<form action='MatriculaAluno' method='post'>");

		out.println("<!-- Combobox de Aluno -->" + "			<p>"
				+ "	<select class='w3-input w3-padding-16 w3-border' required" + "		name='cpfAluno' >" +

				"		<option class='w3-input w3-padding-16 w3-border' value='' disabled"
				+ "			selected>Aluno</option>");

		for (Aluno aluno : alunos) {
			out.println("<option value='" + aluno.getCpf() + "'>" + aluno.getNome() + "</option>");
		}
		out.println("</select>");

		out.println("</p>");

		out.println("<!-- Combobox de Turma -->" + "			<p>"
				+ "	<select class='w3-input w3-padding-16 w3-border' required" + "		name='codigo' >" +

				"		<option class='w3-input w3-padding-16 w3-border' value='' disabled"
				+ "			selected>Turma</option>");

		for (Turma turma : turmas) {
			out.println("<option value='" + turma.getCodigo() + "'>" + turma.getCodigo() + "</option>");
		}
		out.println("</select>");

		out.println("</p>");

		out.println("<!-- Submit -->" + "<p>" + "	<button class='w3-button w3-padding-large' type='submit'>"
				+ "		<i class='fa fa-paper-plane'></i> Matricular" + "	</button>" + "</p>");
		out.println("</form>");
		out.println("<p>"+
		"<a href='Index.html'>Voltar ao Início</a>"+
		"</p>");
		out.println("</div>");

		out.println("<!-- END PAGE -->" + "</div>");

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
