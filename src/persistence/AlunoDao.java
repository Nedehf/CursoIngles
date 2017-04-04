package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Aluno;

public class AlunoDao {

	public List<Aluno> AlunosPorTurma(String codigo) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select a.cpf, a.nome, a.email from aluno a, turma t, matricula m where t.codigo = m.turma_codigo and m.aluno_cpf = a.cpf  and t.codigo = ?";
		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, codigo);

			List<Aluno> alunos = new ArrayList<Aluno>();

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");

				Aluno aluno = new Aluno(cpf, nome, email);

				alunos.add(aluno);
			}

			rs.close();
			pstmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

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

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void remover(String cpf, Aluno aluno) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		String sql = "delete from aluno where cpf = ?";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, cpf);

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(String cpf, Aluno aluno) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "update aluno set nome = ?, email = ? where cpf = ?";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getEmail());
			pstmt.setString(3, aluno.getCpf());

			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Aluno> mostrar() {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from aluno";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			List<Aluno> alunos = new ArrayList<Aluno>();

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");

				Aluno aluno = new Aluno(cpf, nome, email);

				alunos.add(aluno);
			}

			rs.close();
			pstmt.close();
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Aluno buscarAluno(String cpf) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from aluno where cpf = ?";
		Aluno aluno = null;
		try {

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String cpfAluno = rs.getString("cpf");
				String nome = rs.getString("nome");
				String email = rs.getString("email");

				aluno = new Aluno();

				aluno.setCpf(cpfAluno);
				aluno.setNome(nome);
				aluno.setEmail(email);

			}

			rs.close();
			pstmt.close();
			return aluno;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}