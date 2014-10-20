package com.secondfloor.ofertame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.secondfloor.model.Anuncio;
import com.secondfloor.ofertame.task.BuscaOfertasTask;

public class BuscaOfertas extends Activity {
	private Button btnPesquisar;
	private ListView lstViewOfertas;
	private TextView filtroTitulo;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_ofertas);
        
        filtroTitulo = (TextView) findViewById(R.id.txtFiltroTitulo);
        lstViewOfertas = (ListView) findViewById(R.id.lstViewOfertas);
        btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				BuscaOfertasTask buscaOfertasTask = new BuscaOfertasTask(BuscaOfertas.this,lstViewOfertas);
				buscaOfertasTask.execute(filtroTitulo.getText().toString());
			}
		});
        
        lstViewOfertas.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int posicao,long id) {
				try {
					Anuncio anuncio = (Anuncio) adapter.getItemAtPosition(posicao);
					Intent i = new Intent(getApplicationContext(), DetalheOferta.class);
					Bundle b = new Bundle();
					b.putSerializable("paramAnuncio", anuncio);
					i.putExtras(b);
					startActivity(i);
					
				} catch (Exception e) {
					Log.e("Erro ao recuperar o adapter", e.getMessage());
				}
			}
		});
	}
}
