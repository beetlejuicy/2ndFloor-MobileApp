package com.secondfloor.ofertame.task;

import com.secondfloor.messages.AtribuirRatingOfertaResponse;
import com.secondfloor.servicesRest.AnuncioRest;

import android.os.AsyncTask;
import android.util.Log;

public class RatingOfertaTask extends AsyncTask<String, Double, AtribuirRatingOfertaResponse>{

	@Override
	protected AtribuirRatingOfertaResponse doInBackground(String... params) {
		AtribuirRatingOfertaResponse response = null;
		
		Log.i("RatingOfertaTask", "Inicia thread" );
		try {
			String consumidorId = params[0];
			String produtoId = params[1];
			String rating = params[2];
			
			response = new AnuncioRest().AtribuirRatingPara(consumidorId, produtoId, rating);
		} catch (Exception e) {
			Log.e("RatingOfertaTask.doInBackground.Exception", e.getMessage());
		}
		Log.i("RatingOfertaTask.AtribuirRatingPara.Success", String.valueOf(response.getSuccess()));
		return response;
	}

}
