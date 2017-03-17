package testes_main;

import beans.Aluno;
import persistence.AlunoDao;

public class Main {

	public static void main(String[] args) {

	
		Aluno aluno = new Aluno();
		AlunoDao dao = new AlunoDao();

		/*
		aluno.setCpf("12345");
		aluno.setNome("Fulano");
		aluno.setEmail("aluno@a.com");
*/
		
	//dao.inserir(aluno);
	
		dao.remover("123", aluno);

	}

}
