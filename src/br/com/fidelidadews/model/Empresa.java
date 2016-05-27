package br.com.fidelidadews.model;

public class Empresa {
	
	private String cnpj;
	private String senha;
	private String descricao;
	private Double latitude;
	private Double longitude;
	
	
	
	public Empresa() {
	}
	public Empresa(String cnpj, String senha, String descricao,
			Double latitude, Double longitude) {
		super();
		this.cnpj = cnpj;
		this.senha = senha;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", senha=" + senha + ", descricao="
				+ descricao + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}
	
	
}
