package com.secondfloor.model;

import java.io.Serializable;
import java.util.Calendar;

public class Anuncio implements Serializable{
	private String id;
	private String titulo;
	private String dataOferta;
	private String endereco;
	private String fornecedor;
	private String anunciante;
	private Float classificacaoAnunciante;
	private Float preco;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getAnunciante() {
		return anunciante;
	}
	public void setAnunciante(String anunciante) {
		this.anunciante = anunciante;
	}
	public Float getClassificacaoAnunciante() {
		return classificacaoAnunciante;
	}
	public void setClassificacaoAnunciante(Float classificacaoAnunciante) {
		this.classificacaoAnunciante = classificacaoAnunciante;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public String getDataOferta() {
		return dataOferta;
	}
	public void setDataOferta(String dataOferta) {
		this.dataOferta = dataOferta;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
