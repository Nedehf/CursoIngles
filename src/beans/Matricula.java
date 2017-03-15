package beans;

import java.util.Date;

public class Matricula {

	Date ts = new Date();
	double nota;
	double frequencia;

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Matricula(Date ts, double nota, double frequencia) {
		super();
		this.ts = ts;
		this.nota = nota;
		this.frequencia = frequencia;
	}

	public Date getTs() {
		return ts;
	}

	public void setTs(Date ts) {
		this.ts = ts;
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

}
