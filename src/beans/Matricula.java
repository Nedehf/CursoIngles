package beans;

import java.util.Date;

public class Matricula {

	private Date data_matricula = new Date();

	private String aluno_cpf;
	private String turma_codigo;
	double nota;
	double frequencia;

	public Date getData_matricula() {
		return data_matricula;
	}

	public void setData_matricula(Date data_matricula) {
		this.data_matricula = data_matricula;
	}

	public String getAluno_cpf() {
		return aluno_cpf;
	}

	public void setAluno_cpf(String aluno_cpf) {
		this.aluno_cpf = aluno_cpf;
	}

	public String getTurma_codigo() {
		return turma_codigo;
	}

	public void setTurma_codigo(String turma_codigo) {
		this.turma_codigo = turma_codigo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(double frequencia) {
		this.frequencia = frequencia;
	}

	public Matricula() {
		super();

	}

	public Matricula(String aluno_cpf, String turma_codigo, Date data_matricula, double nota, double frequencia) {
		super();

		this.aluno_cpf = aluno_cpf;
		this.turma_codigo = turma_codigo;
		this.data_matricula = data_matricula;

		this.nota = nota;
		this.frequencia = frequencia;
	}

}
