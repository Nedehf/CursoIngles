package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.Matricula;
import beans.Turma;

public class MatriculaDao {

	public void inserir(Matricula matricula) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		String sql = "insert into matricula (aluno_cpf, turma_codigo, data_matricula, nota, frequencia) values (?, ?, ?, ?, ?)";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, matricula.getAluno_cpf());
			pstmt.setString(2, matricula.getTurma_codigo());
			pstmt.setTimestamp(3, new Timestamp(matricula.getData_matricula().getTime()));
			pstmt.setDouble(4, matricula.getNota());
			pstmt.setDouble(5, matricula.getFrequencia());

			pstmt.executeUpdate();
			// pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			// throw new RuntimeException(e);
		} finally {
			try {
				// if (conexao != null)
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void remover(){
		
	}

	public void alterar(String aluno_cpf, String turma_codigo, Matricula matricula) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "update matricula set nota = ?, frequencia = ? where codigo = ?";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setDouble(1, matricula.getFrequencia());
			pstmt.setDouble(2, matricula.getNota());

			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {
				// if (conexao != null)
				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Matricula> mostrar() {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from matricula group by data_matricula desc";

		try {
			
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			List<Matricula> matriculas = new ArrayList<Matricula>();
			Matricula matricula = null;
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String aluno_cpf = rs.getString("aluno_cpf");
				String turma_codigo = rs.getString("turma_codigo");
				Timestamp data_matricula = rs.getTimestamp("data_matricula");
				double nota = rs.getDouble("nota");
				double frequencia = rs.getDouble("frequencia");
				
				matricula = new Matricula();

				matricula.setAluno_cpf(aluno_cpf);
				matricula.setTurma_codigo(turma_codigo);
				matricula.setData_matricula(data_matricula);
				matricula.setNota(nota);
				matricula.setFrequencia(frequencia);
				
				matriculas.add(matricula);
			}

			rs.close();
			pstmt.close();
			return matriculas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
