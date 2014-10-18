package com.secondfloor.ofertame;

import java.util.List;

import com.secondfloor.model.Anuncio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AnuncioAdapter extends ArrayAdapter<Anuncio> {

	public AnuncioAdapter(Context context, List<Anuncio> anuncios) {
		super(context, 0, anuncios);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Anuncio anuncio = getItem(position);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.lista_pesquisa_anuncios, parent, false);
		}

		TextView txtTitulo = (TextView) convertView
				.findViewById(R.id.listaPesquisa_txtTitulo);
		TextView txtPreco = (TextView) convertView
				.findViewById(R.id.listaPesquisa_txtPreco);

		txtTitulo.setText(anuncio.getTitulo());
		txtPreco.setText(String.format("%.2f", anuncio.getPreco()));

		return convertView;

	}
}
