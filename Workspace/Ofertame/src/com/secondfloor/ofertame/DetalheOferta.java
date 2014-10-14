package com.secondfloor.ofertame;
import org.w3c.dom.Text;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

import com.secondfloor.contracts.ServiceAnuncio;
import com.secondfloor.model.Anuncio;
import com.secondfloor.ofertame.R;


public class DetalheOferta extends Activity{
	private Text txtTitulo;
	private Text txtData;
	private Text txtEndereco;
	private Text txtFornecedor;
	private RatingBar ratingAnunciante;
	private Text txtAnunciante;
	private RatingBar ratingInteresseOferta;
	private ServiceAnuncio servicoAnuncio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhe_oferta);
		
		txtTitulo = (Text) findViewById(R.id.txtDetalheTitulo);
		txtData = (Text) findViewById(R.id.txtDetalheData);
		txtEndereco = (Text) findViewById(R.id.txtDetalheEndereco);
		txtFornecedor = (Text) findViewById(R.id.txtDetalheFornecedor);
		txtAnunciante = (Text) findViewById(R.id.txtDetalheAnunciante);
		ratingAnunciante = (RatingBar) findViewById(R.id.ratingDetalheAnunciante);
		ratingInteresseOferta = (RatingBar) findViewById(R.id.ratingDetalheInteresseOferta);
		ratingInteresseOferta.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,boolean fromUser) {
				//servicoAnuncio.publicarInteresseOferta(idAnuncio, rating);
			}
		});
	}
	
	private void fillScreen(Anuncio anuncio)
	{
		txtTitulo.setTextContent(anuncio.getTitulo());
		//txtData.setTextContent(anuncio.getDataOferta());
		txtEndereco.setTextContent(anuncio.getEndereco());
		txtFornecedor.setTextContent(anuncio.getFornecedor());
		txtAnunciante.setTextContent(anuncio.getAnunciante());
		ratingAnunciante.setRating(anuncio.getClassificacaoAnunciante());
		ratingAnunciante.setEnabled(false);
	}
}