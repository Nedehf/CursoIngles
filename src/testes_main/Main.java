package testes_main;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
		
		
		//String stats = t.getSala();
		
		//System.out.println(stats);
		
		Turma t = tdao.buscar("12");
		System.out.println(t.getCodigo());
		
		Turma turminha;
		turminha = tdao.ReachCodigo("Avançado 2", "Dan", "24EFM", "9", 12, "ATIVA");
		System.out.println(turminha.getCodigo());
		
//		System.out.println(t.getCodigo());
//		System.out.println(t.getHorario());
		
		//AlunoDao aldao = new AlunoDao();
		//List<Aluno> als = aldao.mostrar();
		
		
		//System.out.println(tdao.ReachCodigo("Avançado 2", "Dan", "24EFM", "9", 12, "ATIVA"));
		
		
	//	for (Aluno al : als) {
		//	System.out.println(al.getCpf());
	//	}
			

	
		
//vai fazendo e testando por aqui ok
	}

}
