package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Turma;
import persistence.TurmaDao;

@WebServlet("/EditarTurma")
public class EditarTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarTurma() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] lvls = { "Básico 1", "Básico 2", "Intermediário 1", "Intermediário 2", "Avançado 1", "Avançado 2" };
		String[] horarios = { "24ABM", "24CDM", "24EFM", "24ABT", "24CDT", "24EFT", "24ABN", "24CDN", "35ABM", "35CDM",
				"35EFM", "35ABT", "35CDT", "35EFT", "35ABN", "35CDN" };
		String[] hrInfo = { "Seg/Qua 7h30 - 9h10 (24 AB M)", "Seg/Qua 9h30 - 11h10 (24 CD M)",
				"Seg/Qua 11h20 - 13h (24 EF M)", "Seg/Qua 13h30 - 15h10 (24 AB T)", "Seg/Qua 15h30 - 17h10 (24 CD T)",
				"Seg/Qua 17h20 - 19h (24 EF T)", "Seg/Qua 19h - 20h40 (24 AB N)", "Seg/Qua 21h - 22h40 (24 CD N)",
				"Ter/Qui 7h30 - 9h10 (35 AB M)", "Ter/Qui 9h30 - 11h10 (35 CD M)", "Ter/Qui 11h20 - 13h (35 EF M)",
				"Ter/Qui 13h30 - 15h10 (35 AB T)", "Ter/Qui 15h30 - 17h10 (35 CD T)", "Ter/Qui 17h20 - 19h (35 EF T)",
				"Ter/Qui 19h - 20h40 (35 AB N)", "Ter/Qui 21h - 22h40 (35 CD N)" };

		String codturma = request.getParameter("codturma");
		TurmaDao dao = new TurmaDao();
		Turma t = dao.buscar(codturma);
		


		PrintWriter out = response.getWriter();

		out.println("<html>");
		
		out.println("<head>");
		
		out.println("<meta charset='ISO-8859-1'>");		
		out.println("<title>Alteração de Turma</title>");		
		
		out.println("<link rel='stylesheet' href='https://www.w3schools.com/w3css/3/w3.css'>" + 
					"<link rel='stylesheet'	href='https://fonts.googleapis.com/css?family=Montserrat'>" + 
					"<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>");
		
		out.println("</head>");

		out.println("<style>");
		
		out.println("body, h1, h2, h3, h4, h5, h6 {	font-family: 'Montserrat', sans-serif" + "}" +

				"h3 { color: white; }" +

				"input[type='radio'] { margin: 0 10px 0 10px; }" +

				".w3-row-padding img { 	margin-bottom: 12px }" +

				"/* Set the width of the sidebar to 120px */" + 
				".w3-sidebar { width: 120px; background: #222; }" +

				"/* Add a left margin to the 'page content' that matches the width of the sidebar (120px) */" +
				"#main { margin-left: 120px }" +

				"/* Remove margins from 'page content' on small screens */" +
				"@media only screen and (max-width: 600px) { #main { margin-left: 0	} }" +

				".bgimg { background-position: center; background-repeat: no-repeat; background-size: cover; background-image: url('Resources\\BG_01.jpg');	min-height: 100%;" + "}");
		
		out.println("</style>");

		out.println("<body class='w3-black'>");

		out.println("<nav class='w3-sidebar w3-hide-medium w3-hide-small' style='width: 30%'>"+
					"<div class='bgimg'></div>" + 
					"</nav>");

		out.println("<!-- Page Content -->" + 
				
					"<div class='w3-main w3-padding-large' style='margin-left: 29%'>" +
					"<div class='w3-padding-64 w3-content w3-text-grey' id='cadastro' style='margin-bottom: 64px'>" + 
						"<h2 class='w3-text-light-grey'>Alteração de Turma</h2>" + 
						"<hr style='width: 200px' class='w3-opacity'>");

		out.println("<!-- Campos -->" + 
						"<p>Altere o campo a ser modificado abaixo:</p>" +

					"<form action='AtualizarTurma' method='post'>");

		out.println("<!-- Codigo da Turma -->" + 
					"<p>" +
					"<input class='w3-input w3-padding-16 w3-border' type='text' placeholder='Código da Turma' disabled name='codigo' value='"+ t.getCodigo() +"'>" +
				 	"</p>");

		out.println("<!-- Professor -->" + 
					"<p>"
				+ "	<input class='w3-input w3-padding-16 w3-border' type='text'	placeholder='Professor' required name='professor' value='" + t.getProfessor() + "'>"
				+ "	</p>");

		out.println("<!-- Horario (ComboBox) -->" + 
					"<p>" +
					"<select class='w3-input w3-padding-16 w3-border' required name='horario' >" +
					"<option class='w3-input w3-padding-16 w3-border' value='' disabled selected >Horário</option>");

		for (int j = 0; j < horarios.length; j++) {

			if (t.getHorario().equals(horarios[j])){
				out.println("<option class='w3-input w3-padding-16 w3-border' value='" + horarios[j] + "' selected>"+ hrInfo[j] + "</option>");
				}else{
				out.println("<option class='w3-input w3-padding-16 w3-border' value='" + horarios[j] + "'>" + hrInfo[j]+ "</option>");
				}
			}

		out.println("</select>");
		out.println("</p>");

		
		out.println("<!-- Numero da Sala -->" + 
					"<p>" +
					"<input class='w3-input w3-padding-16 w3-border' type='text' placeholder='Número da Sala' required name='sala' value='" + t.getSala() + "'>" +
					"</p>");

		out.println("<!-- Qtde de Alunos -->" + 
					"<p>" +
					"<input class='w3-input w3-padding-16 w3-border' type='text' placeholder='Quantidade máxima de alunos' required name='quantidade' value='" + t.getQtde_maxima()+"'>" + 
					"</p>");

		out.println("<!-- Nível -->" + 
					"<p>" +
					"<input class='w3-input w3-padding-16 w3-border' type='text' placeholder='Nível' disabled name='lvl'>" + 
					"</p>");

		out.println("<table>");
		out.println("<tr>");

		for (String Nivs : lvls) {

			if (t.getNivel().equals(Nivs))
				out.println(
						"<td> <input class='w3-radio w3-padding-16 w3-border' type='radio' required name='nivel' value='"
								+ Nivs + "' checked>" + Nivs + "</td>");
			else
				out.println(
						"<td> <input class='w3-radio w3-padding-16 w3-border' type='radio' required name='nivel' value='"
								+ Nivs + "'>" + Nivs + "</td>");
		}
		out.println("</tr>");
		out.println("</table>");

		out.println("<!-- Status -->" + "			<p>"
				+ "				<input class='w3-input w3-padding-16 w3-border' type='text'"
				+ "					placeholder='Status' disabled name='sts'>");

		out.println(
				"<input class='w3-radio w3-padding-16 w3-border' type='radio' required name='status' value='ATIVA' checked> Ativa");

		out.println(
				"<input class='w3-radio w3-padding-16 w3-border' type='radio' required name='status' value='INATIVA'> Inativa ");

		out.println("</p>");

		out.println("<!-- Submit -->" + "<p>" + "	<button class='w3-button w3-padding-large' type='submit'>"
				+ "		<i class='fa fa-paper-plane'></i> Atualizar" + "	</button>" + "</p>");
		out.println("</form>");
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
