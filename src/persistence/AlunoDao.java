package persistence;

public class AlunoDao {
	
	private Connection conexao;
	
	public AlunoDao{
	this.conexao = new ConnectionFactory().getConnection();
		
	}
	
	public void inserir(Aluno aluno){
		
		String sql = "insert into aluno" + "(cpf, nome, email)" + "values (?, ?, ?)";
		
		try{
		
			PreparedStatement pstmt = conexao.prepareStatement(sql);
			
			pstmt.setString(1, aluno.getCpf());
			pstmt.setString(2, aluno.getNome());
			pstmt.setString(3, aluno.getEmail());
			
			pstmt.execute();
			pstmt.close();
			
			
		}catch (SQLException e){
			throw new RuntimeException(e);	
		}
		
	}

	public void remover(){
		
	}

	public void alterar(){
		
	}

	public void mostrar(){
		
	}


}
