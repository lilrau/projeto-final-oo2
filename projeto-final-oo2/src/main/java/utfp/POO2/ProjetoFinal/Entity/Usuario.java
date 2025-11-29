package utfp.POO2.ProjetoFinal.Entity;

import java.sql.Date;

public class Usuario {
	private int codUsuario;
	private String nome;
	private String login;	
	private Date dataNascimento;
    private String sexo;
    private String senha;
public Usuario() {

}
    
	public Usuario(String nome, String login, Date dataNascimento, String sexo, String senha) {
	super();
	this.nome = nome;
	this.login = login;
	this.dataNascimento = dataNascimento;
	this.sexo = sexo;
	this.senha = senha;
}




	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
