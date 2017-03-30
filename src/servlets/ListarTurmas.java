package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

		out.println("<!DOCTYPE html>" + "<html>" + "<head>" + "meta charset='ISO-8859-1'>"
				+ "<title>Lista de Turmas</title>"
				+ "<link rel='stylesheet' href='https://www.w3schools.com/w3css/3/w3.css'>" + "<link rel='stylesheet'"
				+ "	href='https://fonts.googleapis.com/css?family=Montserrat'>" + "<link rel='stylesheet'"
				+ "	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>"
				+ "</head>");

		// CSS
		out.println("<style>" + 
				"#customers {font-family: 'Montserrat', sans-serif; border-collapse: collapse; width: 100%; }" +

				"#customers td, #customers th { border: 1px solid #ddd; padding: 4px; }" +

				"#customers tr:nth-child(even) { background-color: #f2f2f2; }" +

				"#customers tr:hover { background-color: #ddd; }" +

				"#customers th { padding-top: 12px; padding-bottom: 12px; }" +

				"</style>");

		out.println("<body class='w3-black'>" +

				"<div class='w3-content w3-text-grey'" + "	style='margin-bottom: 10px; margin-left: 10px;'>"
				+ "	<h4 style='margin-bottom: -20px;'>Turmas</h4>" + "	<hr class='w3-opacity'"
				+ "		style='display: inline-block; width: 80px; margin-bottom: 10px;'>" + "</div>" +

				// Criando cabeçalho da tabela
				"<table class='w3-white w3-center' id='customers'>" + "	<tr>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Cod Turma</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Nível</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Professor</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Horário</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Nª Sala</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Qtde de Alunos</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'>Status</th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'></th>"
				+ "		<th class='w3-dark-grey w3-xlarge w3-padding-32'></th>" + "	</tr>");

		// Adicionando turmas na tabela
		for (Turma t : turmas) {

			// Turmas ATIVAS
			if (t.getStatus().equals("ATIVA")) {
				out.println("<tr>" + 
						"<td>"+t.getCodigo()+"</td>" + 
						"<td>"+t.getNivel()+"</td>" + 
						"<td>"+t.getProfessor()+"</td>" + 
						"<td>"+t.getHorario()+"</td>" +
						"<td>"+t.getSala()+"</td>" + 
						"<td>"+t.getQtde_maxima()+"</td>" + 
						"<td>"+t.getStatus()+"</td>" +
						"<td><a href='Delete'> <img src='Resources\\Bin_01.png'alt='delete.ico' style='width: 18px; height: 18px; border: 0;'>" + 
						"</a></td>"+
						"<td><a href='EditarTurma'> <img src='Resources\\Edit_01.png'alt='Edit.ico' style='width: 18px; height: 18px; border: 0;'>" + 
						"</a></td>" + "</tr>");
			} else {

				// Turmas INATIVAS
				out.println("<tr style='background-color: #ce0e0e'>" + 
						"<td>"+t.getCodigo()+"</td>" + 
						"<td>"+t.getNivel()+"</td>" + 
						"<td>"+t.getProfessor()+"</td>" + 
						"<td>"+t.getHorario()+"</td>" +
						"<td>"+t.getSala()+"</td>" + 
						"<td>"+t.getQtde_maxima()+"</td>" + 
						"<td>"+t.getStatus()+"</td>" +
						"<td><a href='Delete'> <img src='Resources\\Bin_01.png' alt='delete.ico' style='width: 18px; height: 18px; border: 0;'>" + 
						"</a></td>" +
						"<td><img src='Resources\\Edit_01.png' alt='Edit.ico' class='w3-opacity-max' style='width: 18px; height: 18px; border: 0;'>"
						+ "</td>" + "</tr>");
			}

		}
		// Fim da Tabela

		// Fim do Html
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
