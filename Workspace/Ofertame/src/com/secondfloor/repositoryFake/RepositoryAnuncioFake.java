package com.secondfloor.repositoryFake;

import java.util.ArrayList;
import java.util.List;

import com.secondfloor.model.Anuncio;
import com.secondfloor.repository.RepositoryAnuncio;

public class RepositoryAnuncioFake implements RepositoryAnuncio{

	@Override
	public List<Anuncio> pesquisarAnuncioPorTitulo(String titulo) {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		Anuncio a1 = new Anuncio();
		a1.setTitulo("Monitor 28");
		a1.setDataOferta("01/10 - 20/10");
		a1.setClassificacaoAnunciante(4.5f);
		a1.setAnunciante("Extra Supermercados");
		a1.setFornecedor("Samsung");
		a1.setPreco(500f);
		a1.setEndereco("AV CAPITAO MARIO TOLEDO DE CAMARGO - SANTO ANDRE - SP CEP: 09400-500");
		
		Anuncio a2 = new Anuncio();
		a2.setTitulo("Monitor e Tv 32");
		a2.setDataOferta("01/10 - 20/10");
		a2.setClassificacaoAnunciante(4.5f);
		a2.setAnunciante("Extra Supermercados");
		a2.setFornecedor("Samsung");
		a2.setPreco(700f);
		a2.setEndereco("AV CAPITAO MARIO TOLEDO DE CAMARGO - SANTO ANDRE - SP CEP: 09400-500");
		
		anuncios.add(a1);
		anuncios.add(a2);
		
		return anuncios;
	}


	@Override
	public void publicarInteresseOferta(int idAnuncio, float interesse) {
		// TODO Auto-generated method stub
		
	}

}
