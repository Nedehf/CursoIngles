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
import persistence.AlunoDao;
import persistence.TurmaDao;

@WebServlet("/PreparaMatricula")
public class PreparaMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TurmaDao tdao = new TurmaDao();
		List<Turma> turmas = tdao.mostrar();
		
//		for (Turma t : turmas) {
//			System.out.println(t.getCodigo()+""+t.getHorario());
//		}
		

		AlunoDao adao = new AlunoDao();
		List<Aluno> alunos = adao.mostrar();
		
//		for (Aluno al : alunos) {
//			System.out.println(al.getCpf()+""+al.getNome());
//		}
		

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<link rel='stylesheet' href='https://www.w3schools.com/w3css/3/w3.css'>");
		out.println("<link rel='stylesheet'");
		out.println("	href='https://fonts.googleapis.com/css?family=Montserrat'>");
		out.println("<link rel='stylesheet'");
		out.println("	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");

		out.println("<title>Matricula</title>");
		out.println("</head>");

		out.println("<style>");
		out.println("body, h1, h2, h3, h4, h5, h6 {");
		out.println("font-family: 'Montserrat', sans-serif");
		out.println("}");

		out.println(".w3-row-padding img {");
		out.println("margin-bottom: 12px");
		out.println("}");

		out.println("/* Set the width of the sidebar to 120px */ .w3-sidebar {");
		out.println("width: 120px;");
		out.println("background: #222;");
		out.println("}");

		out.println(
				"/* Add a left margin to the 'page content' that matches the width of the sidebar (120px) */ #main {");
		out.println("margin-left: 120px");
		out.println("}");

		out.println(
				"/* Remove margins from 'page content' on small screens */ @media only screen and (max-width: 600px) {");
		out.println("#main {");
		out.println("	margin-left: 0");
		out.println("}");
		out.println("}");

		out.println(".bgimg {");
		out.println("background-position: center;");
		out.println("background-repeat: no-repeat;");
		out.println("background-size: cover;");
		out.println("background-image: url('Resources\\BG_01.jpg');");
		out.println("min-height: 100%;");
		out.println("}");
		out.println("</style>");

		out.println("<body class='w3-black'>");

		out.println("<nav class='w3-sidebar w3-hide-medium w3-hide-small' style='width: 30%'>");
		out.println("	<div class='bgimg'></div>");
		out.println("</nav>");

		out.println("<!-- Page Content -->");
		out.println("<div class='w3-main w3-padding-large' style='margin-left: 29%'>");

		out.println("	<div class='w3-padding-64 w3-content w3-text-grey' id='matricula'");
		out.println("		style='margin-bottom: 64px'>");
		out.println("		<h2 class='w3-text-light-grey'>Matricula</h2>");
		out.println("		<hr style='width: 200px' class='w3-opacity'>");

		out.println("		<!-- Campos -->");
		out.println("		<p>Preencha os campos abaixo:</p>");

		out.println("		<form action='MatricularAluno' method='post'>");

		out.println("			<!-- Alunos (ComboBox) -->");
		out.println("			<p>");
		out.println("				<select class='w3-select w3-padding-16 w3-border' required name='Aluno'>");
		out.println("					<option value='' disabled selected>Aluno</option>");
		for (Aluno aluno : alunos) {
			out.println("<option value='" + aluno.getCpf() + "'>" + aluno.getNome() + " - CPF: " + aluno.getCpf()
					+ "</option>");
		}
		out.println("				</select>");
		out.println("			</p>");

		out.println("			<!-- Turmas (ComboBox) -->");
		out.println("			<p>");
		out.println("				<select class='w3-select w3-padding-16 w3-border' required name='Turma'>");
		out.println("					<option value='' disabled selected>Turma</option>");
		for (Turma turma : turmas) {
			out.println("<option value='" + turma.getCodigo() + "'>" + turma.getNivel() + " - " + turma.getHorario()
					+ " (" + turma.getCodigo() + ")" + "</option>");
		}
		out.println("			</p>");

		out.println("			<!-- Submit -->");
		out.println("			<p>");
		out.println("				<button class='w3-button w3-padding-large' type='submit'>");
		out.println("					<i class='fa fa-paper-plane'></i> Matricular");
		out.println("				</button>");
		out.println("			</p>");
		out.println("		</form>");

		out.println("<p> <a href='Index.html'>Voltar ao Início</a> </p>");

		out.println("	</div>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
