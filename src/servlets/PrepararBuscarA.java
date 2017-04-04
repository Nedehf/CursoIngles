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
import beans.Matricula;
import beans.Turma;
import persistence.AlunoDao;
import persistence.MatriculaDao;

@WebServlet("/PrepararBuscarA")
public class PrepararBuscarA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codturma = request.getParameter("codigo");

		AlunoDao aldao = new AlunoDao();
		List<Aluno> als = aldao.AlunosPorTurma(codturma);

		MatriculaDao mdao = new MatriculaDao();

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println(" <html>");

		out.println(" <head>");
		out.println("     <title>Bootstrap Example</title>");
		out.println("     <meta charset=\"utf-8\">");
		out.println("     <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println(
				"     <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		out.println("     <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/3/w3.css\">");
		out.println("     <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">");
		out.println(
				"     <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
		out.println("     <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js\"></script>");
		out.println(
				"     <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		out.println(" </head>");

		out.println(" <style>");
		out.println("     body,");
		out.println("     h1,");
		out.println("     h2,");
		out.println("     h3,");
		out.println("     h4,");
		out.println("     h5,");
		out.println("     h6 {");
		out.println("         font-family: \"Montserrat\", sans-serif");
		out.println("     }");
		out.println("     ");
		out.println("     .w3-row-padding img {");
		out.println("         margin-bottom: 12px");
		out.println("     }");
		out.println("     /* Set the width of the sidebar to 120px */");
		out.println("     ");
		out.println("     .w3-sidebar {");
		out.println("         width: 120px;");
		out.println("         background: #222;");
		out.println("     }");
		out.println(
				"     /* Add a left margin to the \"page content\" that matches the width of the sidebar (120px) */");
		out.println("     ");
		out.println("     #main {");
		out.println("         margin-left: 120px");
		out.println("     }");
		out.println("     /* Remove margins from \"page content\" on small screens */");
		out.println("     ");
		out.println("     @media only screen and (max-width: 600px) {");
		out.println("         #main {");
		out.println("             margin-left: 0");
		out.println("         }");
		out.println("     }");
		out.println("     ");
		out.println("     .bgimg {");
		out.println("         background-position: center;");
		out.println("         background-repeat: no-repeat;");
		out.println("         background-size: cover;");
		out.println("         background-image: url('Resources\\\\BG_01.jpg');");
		out.println("         min-height: 100%;");
		out.println("     }");
		out.println("     ");
		out.println("     #customers tr:nth-child(even) {");
		out.println("         background-color: #f2f2f2;");
		out.println("     }");
		out.println("     ");
		out.println("     #customers tr:hover {");
		out.println("         background-color: #ddd;");
		out.println("     }");
		out.println("     ");
		out.println("     #customers td,");
		out.println("     #customers th {");
		out.println("         border: 1px solid #ddd;");
		out.println("         padding: 4px;");
		out.println("     }");
		out.println("     ");
		out.println("     #customers {");
		out.println("         font-family: \"Montserrat\", sans-serif;");
		out.println("         border-collapse: collapse;");
		out.println("         width: 100%;");
		out.println("     }");
		out.println("     /* .modal-transparent */");
		out.println("     ");
		out.println("     .modal-transparent .modal-content {");
		out.println("         background: darkgrey;");
		out.println("         opacity: 1;");
		out.println("         filter: alpha(opacity=100);");
		out.println("     }");
		out.println(" </style>");

		out.println(" <body class=\"w3-black\">");

		out.println("     <nav class=\"w3-sidebar w3-hide-medium w3-hide-small\" style=\"width: 30%\">");
		out.println("         <div class=\"bgimg\"></div>");
		out.println("     </nav>");

		out.println("     <!-- Page Content -->");
		out.println("     <div class=\"w3-main w3-padding-large\" style=\"margin-left: 29%\">");

		out.println(
				"         <div class=\"w3-padding-64 w3-content w3-text-grey\" id=\"busca aluno\" style=\"margin-bottom: 64px\">");
		out.println("             <h2 class=\"w3-text-light-grey\">Buscar Aluno</h2>");
		out.println("             <hr style=\"width: 200px\" class=\"w3-opacity\">");

		out.println("             <!-- Campos -->");
		out.println("             <p>Informe o Cod da Turma:</p>");

		out.println("             <form action=\"PrepararBuscarA\" method=\"post\">");

		out.println("                 <!-- Codigo da turma -->");
		out.println("                 <p>");
		out.println(
				"                     <input class=\"w3-input w3-padding-16 w3-border\" onmouseleave=\"\" type=\"text\" placeholder=\"Código da Turma\" required name=\"codigo\">");
		out.println("                 </p>");

		out.println("                 <!-- Submit -->");
		out.println("                 <p>");
		out.println("                     <button class=\"w3-button w3-padding-large\" type=\"submit\">");
		out.println(" 					<i class=\"fa fa-paper-plane\"></i> Matricular");
		out.println(" 				</button>");
		out.println("                 </p>");
		out.println("             </form>");

		out.println("             <br><br>");

		out.println("             <!--<div class=\"container\">");
		out.println("                  Trigger the modal with a button ");
		out.println(
				"                 <button type=\"button\" class=\"btn btn-info btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">Open Modal</button>-->");

		out.println("             <!-- Modal -->");
		out.println("             <div class=\"modal modal-transparent fade\" id=\"myModal\" role=\"dialog\">");
		out.println("                 <div class=\"modal-dialog\">");

		out.println("                     <!-- Modal content-->");
		out.println("                     <div class=\"modal-content\">");
		out.println("                         <div class=\"modal-header\">");
		out.println(
				"                             <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>");
		out.println("                             <h4 class=\"modal-title\">Nome do Dado a Ser Alterado</h4>");
		out.println("                         </div>");
		out.println("                         <div class=\"modal-body\">");
		out.println("                           ");
		out.println("                           <form action=\"FinalizarBuscarA\" method=\"post\">");
		out.println(" 			");
		out.println(" 			<!-- Nota -->");
		out.println(" 				<p>");
		out.println(" 					<input class=\"w3-input w3-padding-16 w3-border\" type=\"text\"");
		out.println(" 						placeholder=\"Nota\" required name=\"nota\">");
		out.println(" 				</p>");
		out.println(" 				");
		out.println(" 			<!-- Frequência -->");
		out.println(" 				<p>");
		out.println(" 					<input class=\"w3-input w3-padding-16 w3-border\" type=\"text\"");
		out.println(" 						placeholder=\"Frequência\" required name=\"freq\">");
		out.println(" 				</p>");
		out.println(" 				");
		out.println(" 				<!-- CPF -->");
		out.println(" 				<p>");
		out.println(" 					<input class=\"w3-input w3-padding-16 w3-border\" type=\"text\"");
		out.println(" 						placeholder=\"CPF\" required name=\"cpf\">");
		out.println(" 				</p>");
		out.println(" 				<!-- Codigo Turma -->");
		out.println(" 				<p>");
		out.println(" 					<input class=\"w3-input w3-padding-16 w3-border\" type=\"hidden\"");
		out.println(" 						name=\"codigo\" value=\"" + codturma + "\">");
		out.println(" 				</p>");
		out.println(" 						<!-- Submit -->");
		out.println(" 				<p>");
		out.println(" 					<button class=\"w3-button w3-padding-large\" type=\"submit\">");
		out.println(" 						<i class=\"fa fa-paper-plane\"></i> Registrar");
		out.println(" 					</button>");
		out.println(" 				</p>");
		out.println(" 				");
		out.println(" 			");
		out.println(" 			</form>");
		out.println(" 			");
		out.println("                         </div>");
		out.println("                         <div class=\"modal-footer\">");
		out.println(
				"                             <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\" style=\"opacity: 1;\">Close</button>");
		out.println("                         </div>");
		out.println("                     </div>");

		out.println("                 </div>");
		out.println("             </div>");

		out.println("             <!--</div>-->");

		out.println("             <!--Tabela-->");

		out.println("             <table class=\"w3-white w3-center\" id=\"customers\">");
		out.println("                 <tr>");
		out.println("                     <th class=\"w3-dark-grey \">CPF</th>");
		out.println("                     <th class=\"w3-dark-grey \">Nome</th>");
		out.println("                     <th class=\"w3-dark-grey \">E-mail</th>");
		out.println("                     <th class=\"w3-dark-grey \">Data Matrícula</th>");
		out.println("                     <th class=\"w3-dark-grey \">Nota</th>");
		out.println("                     <th class=\"w3-dark-grey \">Frequência</th>");
		out.println("                 </tr>");

		for (Aluno st : als) {
			
			Matricula mt = mdao.buscarMatricula(st.getCpf(),codturma);
			
					out.println("                 <tr data-toggle=\"modal\" data-target=\"#myModal\">");
					out.println("                     <td>" + st.getCpf() + "</td>");
					out.println("                     <td>" + st.getNome() + "</td>");
					out.println("                     <td>" + st.getEmail() + "</td>");
					out.println("                     <td>" + mt.getData_matricula() + "</td>");
					out.println("                     <td>" + mt.getNota() + "</td>");
					out.println("                     <td>" + mt.getFrequencia() + "</td>");
					out.println("                 </tr>");
				
			}
		out.println("             </table>");
		out.println("             <p> <a href=\"Index.html\">Voltar ao Início</a> </p>");

		out.println("         </div>");
		out.println("     </div>");

		out.println(" </body>");

		out.println(" </html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
