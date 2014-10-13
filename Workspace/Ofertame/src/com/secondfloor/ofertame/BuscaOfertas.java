package com.secondfloor.ofertame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class BuscaOfertas extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_ofertas);
        
        TextView filtroTitulo = (TextView) findViewById(R.id.txtFiltroTitulo);
        ListView lstViewOfertas = (ListView) findViewById(R.id.lstViewOfertas);
        
    }


 
}
