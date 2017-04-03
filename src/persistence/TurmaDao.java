package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Aluno;
import beans.Turma;

public class TurmaDao {
	
	public int AlunosPorTurma(String codigo) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select count(*) from aluno a, turma t, matricula m where t.codigo = m.turma_codigo and m.aluno_cpf = a.cpf  and t.codigo = ?";
		int cont = 0;
		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, codigo);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String quantidade = rs.getString("count(*)");
				
				cont = Integer.parseInt(quantidade);

			}

			rs.close();
			pstmt.close();
			return cont;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public Turma buscar(String codigo) {
		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from turma where codigo = ?";
		Turma turma = null;
		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, codigo);
			
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String codigoTurma = rs.getString("codigo");
				String nivel = rs.getString("nivel");
				String professor = rs.getString("professor");
				String horario = rs.getString("horario");
				String sala = rs.getString("sala");
				int qtde_maxima = rs.getInt("qtde_maxima");
				String status = rs.getString("status");

				turma = new Turma();
				
				turma.setCodigo(codigoTurma);
				turma.setNivel(nivel);
				turma.setProfessor(professor);
				turma.setHorario(horario);
				turma.setSala(sala);
				turma.setQtde_maxima(qtde_maxima);
				turma.setStatus(status);
				

			}

			rs.close();
			pstmt.close();
			return turma;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void inserir(Turma turma) {

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

	public void remover(String codigo, Turma turma) {

		Connection conexao = null;
		PreparedStatement pstmt = null;

		String sql = "delete from turma where codigo = ?";

		try {
			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, codigo);

			pstmt.execute();
			pstmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(String codigo, Turma turma) {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "update turma set nivel = ?, professor = ?, horario = ?, sala = ?, qtde_maxima = ?, status = ? where codigo = ?";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);

			pstmt.setString(1, turma.getNivel());
			pstmt.setString(2, turma.getProfessor());
			pstmt.setString(3, turma.getHorario());
			pstmt.setString(4, turma.getSala());
			pstmt.setInt(5, turma.getQtde_maxima());
			pstmt.setString(6, turma.getStatus());
			pstmt.setString(7, turma.getCodigo());

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

	public List<Turma> mostrar() {

		Connection conexao = null;
		PreparedStatement pstmt = null;
		String sql = "select * from curso_ingles.turma order by nivel, horario";

		try {

			conexao = Conexao.getConnection();
			pstmt = conexao.prepareStatement(sql);
			
			List<Turma> turmas = new ArrayList<Turma>();
			Turma turma = null;
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nivel = rs.getString("nivel");
				String professor = rs.getString("professor");
				String horario = rs.getString("horario");
				String sala = rs.getString("sala");
				int qtde_maxima = rs.getInt("qtde_maxima");
				String status = rs.getString("status");

				turma = new Turma();

				turma.setCodigo(codigo);
				turma.setNivel(nivel);
				turma.setProfessor(professor);
				turma.setHorario(horario);
				turma.setSala(sala);
				turma.setQtde_maxima(qtde_maxima);
				turma.setStatus(status);

				turmas.add(turma);
			}

			rs.close();
			pstmt.close();
			return turmas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
