package br.com.fidelidadews.dao;


public class PontuacaoNew {
	private int id;
	private String descricao;
	private double pontos;
	private String usuario_cpf;

	
	
	
	public PontuacaoNew() {
	}




	public PontuacaoNew(int id, String descricao, double pontos,
			String usuario_cpf) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.pontos = pontos;
		this.usuario_cpf = usuario_cpf;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getDescricao() {
		return descricao;
	}




	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




	public double getPontos() {
		return pontos;
	}




	public void setPontos(double pontos) {
		this.pontos = pontos;
	}




	public String getUsuario_cpf() {
		return usuario_cpf;
	}




	public void setUsuario_cpf(String usuario_cpf) {
		this.usuario_cpf = usuario_cpf;
	}




	@Override
	public String toString() {
		return "PontuacaoNew [id=" + id + ", descricao=" + descricao
				+ ", pontos=" + pontos + ", usuario_cpf=" + usuario_cpf ;
	}



}
