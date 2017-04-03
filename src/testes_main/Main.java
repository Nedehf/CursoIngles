package testes_main;

import beans.Aluno;
import beans.Turma;
import persistence.AlunoDao;
import persistence.TurmaDao;

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
	
		//dao.remover("123", aluno);
	
		TurmaDao tdao = new TurmaDao();
		Turma t = tdao.buscar("123456");
		System.out.println(t.getCodigo());
		System.out.println(t.getHorario());
		


		tdao.alterar(t.getCodigo(), t);
		
//vai fazendo e testando por aqui ok
	}

}
