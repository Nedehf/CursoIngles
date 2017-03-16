package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Aluno;

public class AlunoDao {

	public void inserir(Aluno aluno) {
		Connection conexao = null;
		String sql = "insert into aluno" + "(cpf, nome, email)" + "values (?, ?, ?)";

		try {
			conexao = Conexao.getConnection();
			PreparedStatement pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, aluno.getCpf());
			pstmt.setString(2, aluno.getNome());
			pstmt.setString(3, aluno.getEmail());

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void remover() {

	}

	public void alterar() {

	}

	public void mostrar() {

	}

}
