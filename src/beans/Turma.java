package beans;

public class Turma {

	private String codigo;
	private String nivel;
	private String professor;
	private String horario;
	private String sala;
	private int qtde_maxima;
	private String status;

	public Turma() {
		super();

	}

	public Turma(String codigo, String nivel, String professor, String horario, String sala, int qtde_maxima,
			String status) {
		super();
		this.codigo = codigo;
		this.nivel = nivel;
		this.professor = professor;
		this.horario = horario;
		this.sala = sala;
		this.qtde_maxima = qtde_maxima;
		this.status = status;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getQtde_maxima() {
		return qtde_maxima;
	}

	public void setQtde_maxima(int qtde_maxima) {
		this.qtde_maxima = qtde_maxima;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
