package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Turma;
import persistence.TurmaDao;

@WebServlet("/ListarTurmas")
public class ListarTurmas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarTurmas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TurmaDao dao = new TurmaDao();
		List<Turma> turmas = dao.mostrar();

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");

		out.println("<head>");
		out.println("    <meta charset=\"ISO-8859-1\">");
		out.println("    <title>Lista de Turmas</title>");
		out.println("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/3/w3.css\">");
		out.println("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">");
		out.println(
				"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
		out.println("</head>");
		out.println("<style>");
		out.println("    #customers {");
		out.println("        font-family: \"Montserrat\", sans-serif;");
		out.println("        border-collapse: collapse;");
		out.println("        width: 100%;");
		out.println("    }");
		out.println("    #customers td,");
		out.println("    #customers th {");
		out.println("        border: 1px solid #ddd;");
		out.println("        padding: 4px;");
		out.println("    }");
		out.println("    #customers tr:nth-child(even) {");
		out.println("        background-color: #f2f2f2;");
		out.println("    }");
		out.println("    #customers tr:hover {");
		out.println("        background-color: #ddd;");
		out.println("    }");
		out.println("    #customers th {");
		out.println("        padding-top: 12px;");
		out.println("        padding-bottom: 12px;");
		out.println("    }");
		out.println("</style>");

		out.println("		<body class=\"w3-black\">");
		out.println("    <!-- Page Content -->");
		out.println("    <div class=\"w3-text-grey\" id=\"ListaDeTurmas\">");
		out.println("        <h2 class=\"w3-text-light-grey\">Turmas</h2>");
		out.println("        <hr style=\"width: 200px\" class=\"w3-opacity\">");
		// Criando cabeçalho da tabela
		out.println("        <table class=\"w3-white w3-center\" id=\"customers\">");
		out.println("            <tr>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Cod Turma</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Nível</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Professor</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Horário</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Nª Sala</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Qtde de Alunos</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\">Status</th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\"></th>");
		out.println("                <th class=\"w3-dark-grey w3-xlarge w3-padding-32\"></th>");
		out.println("            </tr>");

		// Adicionando turmas na tabela
		for (Turma t : turmas) {

			// Turmas ATIVAS
			if (t.getStatus().equals("ATIVA")) {
				out.println("<tr>");
				out.println("<td>" + t.getCodigo() + "</td>");
				out.println("<td>" + t.getNivel() + "</td>");
				out.println("<td>" + t.getProfessor() + "</td>");
				out.println("<td>" + t.getHorario() + "</td>");
				out.println("<td>" + t.getSala() + "</td>");
				out.println("<td>" + t.getQtde_maxima() + "</td>");
				out.println("<td>" + t.getStatus() + "</td>");
				out.println("<td>");
				out.println("<a href=\"DeletarTurma?codturma=" + t.getCodigo()
						+ "\" onclick=\"return confirm(\"Deseja Deletar Registro?\")\"> <img src=\"Resources\\Bin_01.png\"alt=\"delete.ico\" style=\"width: 18px; height: 18px; border: 0;\"></a>");
				out.println("</td>");
				out.println("<td>");
				out.println("<a href=\"EditarTurma?codturma=" + t.getCodigo()
						+ "\"> <img src=\"Resources\\Edit_01.png\"alt=\"Edit.ico\" style=\"width: 18px; height: 18px; border: 0;\"></a>");
				out.println("</td>");
				out.println("<tr>");
			} else {

				// Turmas INATIVAS
				out.println("<tr style=\"background-color: #ce0e0e\">");
				out.println("<td>" + t.getCodigo() + "</td>");
				out.println("<td>" + t.getNivel() + "</td>");
				out.println("<td>" + t.getProfessor() + "</td>");
				out.println("<td>" + t.getHorario() + "</td>");
				out.println("<td>" + t.getSala() + "</td>");
				out.println("<td>" + t.getQtde_maxima() + "</td>");
				out.println("<td>" + t.getStatus() + "</td>");
				out.println("<td>");
				out.println("<a href=\"DeletarTurma?codturma=" + t.getCodigo()
						+ "\" onclick=\"return confirm(\"Deseja Deletar Registro?\")\"> <img src=\"Resources\\Bin_01.png\" alt=\"delete.ico\" style=\"width: 18px; height: 18px; border: 0;\"></a>");
				out.println("</td>");
				out.println("<td>");
				out.println(
						"<img src=\"Resources\\Edit_01.png\" alt=\"Edit.ico\" class=\"w3-opacity-max\" style=\"width: 18px; height: 18px; border: 0;\">");
				out.println("</td>");
				out.println("</tr>");
			}

		}
		// Fim da Tabela

		// Fim do Html
		out.println("</table>");

		out.print("<a href=\"Index.html\">Voltar ao Início</a>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
