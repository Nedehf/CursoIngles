package testes_main;

import beans.Aluno;
import persistence.AlunoDao;

public class Main {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();

		aluno.setCpf("123");
		aluno.setNome("Fulano");
		aluno.setEmail("aluno@a.com");

		AlunoDao dao = new AlunoDao();
		dao.inserir(aluno);

	}

}
