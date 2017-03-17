package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Aluno;

public class AlunoDao {

	public void inserir(Aluno aluno) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into aluno (cpf, nome, email) values (?, ?, ?)";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, aluno.getCpf());
			pstmt.setString(2, aluno.getNome());
			pstmt.setString(3, aluno.getEmail());

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

	public void remover(String cpf, Aluno aluno) {
		//esse método é irrelevante pro trabalho?
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from aluno where cpf = ?";
				
				try{
					conexao = Conexao.getConnection();
					pstmt = conexao.prepareStatement(sql);
					
					pstmt.setString(1, cpf);
					
					pstmt.execute();
					pstmt.close();
					
				}catch (SQLException e){
					throw new RuntimeException(e);
				}

	}

	public void alterar(String cpf, Aluno aluno) {
		
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "update aluno set nome = ?, email = ? where cpf = ?";
		
		try{
			
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getEmail());
			pstmt.setString(3, cpf);

			pstmt.executeUpdate();
		}catch (SQLException e){
			
			e.printStackTrace();
			
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

	public void mostrar() {
		
		

	}

}
