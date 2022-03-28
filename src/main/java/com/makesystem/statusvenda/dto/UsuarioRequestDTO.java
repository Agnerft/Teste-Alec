package com.makesystem.statusvenda.dto;

import com.makesystem.statusvenda.Usuario;
import com.opencsv.bean.CsvBindByName;

public class UsuarioRequestDTO {
	
	@CsvBindByName(column = "Login")
	private String login;
	@CsvBindByName(column = "Nome")
	private String nome;
	@CsvBindByName(column = "Login de Terceiros")
	private String loginTerceiro;

	public UsuarioRequestDTO() {

	}

	public UsuarioRequestDTO(String nome) {
		this.nome = nome;
	}

	public UsuarioRequestDTO(String login, String nome, String loginTerceiro) {
		this.login = login;
		this.nome = nome;
		this.loginTerceiro = loginTerceiro;
	}

	public UsuarioRequestDTO(Usuario usuarioDTO) {

		login = usuarioDTO.getLogin();
		nome = usuarioDTO.getNome();
		loginTerceiro = usuarioDTO.getLoginTerceiro();
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
