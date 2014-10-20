package com.secondfloor.dto.extend;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.secondfloor.dto.OfertaDTO;
import com.secondfloor.model.Anuncio;

public class OfertaDTOExtends {
	
	public List<Anuncio> OfertaDtoToAnuncios(OfertaDTO[] ofertas) {
		Log.i("OfertaDTOExtends", "OfertaDtoToAnuncios");
		
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			for (OfertaDTO oferta : ofertas) {
				Anuncio anuncio = new Anuncio();
				anuncio.setTitulo(oferta.getNomeProduto());
				anuncio.setAnunciante(oferta.getAnuncianteRazaoSocial());
				anuncio.setClassificacaoAnunciante(Float.parseFloat(oferta.getAnunciantePontuacao()));
				anuncio.setEndereco(formatarEndereco(oferta));
				anuncio.setFornecedor(oferta.getFabricante());
				anuncio.setPreco(Float.parseFloat(oferta.getValor().replace(',', '.')));
				// anuncio.setDataOferta(dataOferta);
				anuncios.add(anuncio);
			}
		} catch (Exception e) {
			Log.e("Exception", e.getMessage());
		}
		return anuncios;
	}

	private String formatarEndereco(OfertaDTO oferta) 
	{
		StringBuilder sb = new StringBuilder();
		if (oferta.getLogradouro() != null && oferta.getLogradouro() != "") 
		{
			sb.append(oferta.getLogradouro() + " ");
			sb.append("n: " + oferta.getNumero() + " ");
			if (oferta.getComplemento() != null && oferta.getComplemento() != "") 
			{
				sb.append(" - " + oferta.getComplemento() + " ");
			}
			sb.append(oferta.getBairro() + " - ");
			sb.append(oferta.getCidade() + " - ");
			if (oferta.getEstado() != null
					&& (oferta.getEstado().getSigla() != null && oferta
							.getEstado().getSigla() != "")) 
			{
				sb.append(oferta.getEstado().getSigla() + " - ");
			}
			sb.append("CEP: " + oferta.getCep());
		}
		return sb.toString();
	}
}
