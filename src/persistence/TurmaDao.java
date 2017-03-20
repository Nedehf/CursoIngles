package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Turma;

public class TurmaDao {

public void inserir(Turma turma){
	
	Connection conexao = null;
	PreparedStatement pstmt = null;
	
	String sql = "insert into turma (codigo, nivel, professor, horario, sala, qtde_maxima, status) values (?, ?, ?, ?, ?, ?, ?)";

	try {
		conexao = Conexao.getConnection();
		pstmt = conexao.prepareStatement(sql);

		pstmt.setString(1, turma.getCodigo());
		pstmt.setString(2, turma.getNivel());
		pstmt.setString(3, turma.getProfessor());
		pstmt.setString(4, turma.getHorario());
		pstmt.setString(5, turma.getSala());
		pstmt.setInt(6, turma.getQtde_maxima());
		pstmt.setString(7, turma.getStatus());

		pstmt.executeUpdate();
	//	pstmt.close();

	} catch (SQLException e) {
		e.printStackTrace();
	//	throw new RuntimeException(e);
	} finally {
		try {
	//		if (conexao != null)
				pstmt.close();
				conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}

public void remover(){
	
}

public void alterar(){
	
}

public void mostrar(){
	
}


}
