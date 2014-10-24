package com.secondfloor.ofertame.task;

import com.secondfloor.messages.LogonConsumidorResponse;
import com.secondfloor.model.Autenticacao;
import com.secondfloor.ofertame.BuscaOfertas;
import com.secondfloor.services.SegurancaService;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class LogonConsumidorTaks extends AsyncTask<Autenticacao,Double,LogonConsumidorResponse>{
	private Activity context;

	public LogonConsumidorTaks(Activity context)
	{
		this.context = context;
	}
	
	@Override
	protected LogonConsumidorResponse doInBackground(Autenticacao... params) {
		LogonConsumidorResponse response = null;
		
		Log.i("LogonConsumidor", "Inicia thread" );
		try {
			Autenticacao autenticacao = params[0];
			response = new SegurancaService().LogonConsumidor(autenticacao);
		} catch (Exception e) {
			Log.e("LogonConsumidorTaks.doInBackground.Exception", e.getMessage());
		}
		Log.i("LogonConsumidorTaks.LogonConsumidor.Success", String.valueOf(response.getSuccess()));
		return response;
	}
	
	@Override
	protected void onPostExecute(LogonConsumidorResponse result) {
		if(result.getSuccess() == true)
		{
			goScreenBuscaOfertas();
		}
		else
		{
			Toast.makeText(this.context, result.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	    
	public void goScreenBuscaOfertas(){
		Intent trocaTela = new Intent(this.context, BuscaOfertas.class);
		this.context.startActivity(trocaTela);
	}

}
