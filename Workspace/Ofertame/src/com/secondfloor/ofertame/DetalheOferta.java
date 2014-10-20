package com.secondfloor.ofertame;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.secondfloor.model.Anuncio;

public class DetalheOferta extends Activity{
	private TextView txtTitulo;
	private TextView txtData;
	private TextView txtEndereco;
	private TextView txtFornecedor;
	private RatingBar ratingAnunciante;
	private TextView txtAnunciante;
	private RatingBar ratingInteresseOferta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhe_oferta);
		
		Log.i("Detalhe oferta", "Abrindo tela");
		
		txtTitulo = (TextView) findViewById(R.id.txtDetalheTitulo);
		txtData = (TextView) findViewById(R.id.txtDetalheData);
		txtEndereco = (TextView) findViewById(R.id.txtDetalheEndereco);
		txtFornecedor = (TextView) findViewById(R.id.txtDetalheFornecedor);
		txtAnunciante = (TextView) findViewById(R.id.txtDetalheAnunciante);
		ratingAnunciante = (RatingBar) findViewById(R.id.ratingDetalheAnunciante);
		ratingInteresseOferta = (RatingBar) findViewById(R.id.ratingDetalheInteresseOferta);
		ratingInteresseOferta.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,boolean fromUser) {
				
				Toast.makeText(DetalheOferta.this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
			}
		});
		clearScreen();
		
		loadScreen();
	}
	
	private void loadScreen() {
		Bundle b = this.getIntent().getExtras();
		
		if(b!=null)
		{
			Anuncio pAnuncio = (Anuncio)b.getSerializable("paramAnuncio");
			try {
				fillScreen(pAnuncio);
			} catch (Exception e) {
				Log.e("Erro ao preencher a tela detalhe oferta", e.getMessage());
				Toast.makeText(DetalheOferta.this, R.string.msgFalhaDetalheOferta, Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void fillScreen(Anuncio anuncio)
	{
		txtTitulo.setText(anuncio.getTitulo());
		//txtData.setText(anuncio.getDataOferta());
		txtEndereco.setText(anuncio.getEndereco());
		txtFornecedor.setText(anuncio.getFornecedor());
		txtAnunciante.setText(anuncio.getAnunciante());
		ratingAnunciante.setRating(anuncio.getClassificacaoAnunciante());
		ratingAnunciante.setEnabled(false);
	}
	
	private void clearScreen()
	{
		txtTitulo.setText("");
		txtData.setText("");
		txtEndereco.setText("");
		txtFornecedor.setText("");
		txtAnunciante.setText("");
		ratingAnunciante.setRating(0);
		ratingAnunciante.setEnabled(false);
	}
}
