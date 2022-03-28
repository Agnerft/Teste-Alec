package com.makesystem.statusvenda;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Usuario {


	private Long idUsuario;
	private String login;
	private String nome;
	private String loginTerceiro;
	
	public Usuario() {
		
	}
	public Usuario(String login, String nome, String loginTerceiro) {
		super();
		this.login = login;
		this.nome = nome;
		this.loginTerceiro = loginTerceiro;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLoginTerceiro() {
		return loginTerceiro;
	}
	public void setLoginTerceiro(String loginTerceiro) {
		this.loginTerceiro = loginTerceiro;
	}
	
	
}
