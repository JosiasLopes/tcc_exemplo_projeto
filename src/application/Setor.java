package application;

public class Setor {

	public String codigo;
	private String descricao,atribuicao;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = String.valueOf(codigo);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAtribuicao() {
		return atribuicao;
	}
	public void setAtribuicao(String atribuicao) {
		this.atribuicao = atribuicao;
	}
	
	public Setor(int codigo, String descricao, String atribuicao) {
		
		this.codigo = String.valueOf(codigo);
		this.descricao = descricao;
		this.atribuicao = atribuicao;
	}
	
public Setor(int codigo, String descricao) {
		
		this.codigo = String.valueOf(codigo);
		this.descricao = descricao;
		
	}


	
	
	
}
