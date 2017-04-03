package testes_main;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
	
		//dao.remover("123", aluno);
	
//		TurmaDao tdao = new TurmaDao();
//		Turma t = tdao.buscar("123456");
//		System.out.println(t.getCodigo());
//		System.out.println(t.getHorario());
		
		AlunoDao aldao = new AlunoDao();
		List<Aluno> als = aldao.mostrar();
		
		for (Aluno al : als) {
			System.out.println(al.getCpf());
		}
			

	
		
//vai fazendo e testando por aqui ok
	}

}
