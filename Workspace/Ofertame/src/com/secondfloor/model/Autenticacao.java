package com.secondfloor.model;

import java.io.Serializable;

import com.secondfloor.model.enums.TipoAcesso;

public class Autenticacao implements Serializable {
	private String nome;
	private String email;
	private String senha;
	private TipoAcesso tipoAcesso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoAcesso getTipoAcesso() {
		return tipoAcesso;
	}
	public void setTipoAcesso(TipoAcesso tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
	
	
}
