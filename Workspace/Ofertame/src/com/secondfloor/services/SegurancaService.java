package com.secondfloor.services;

import java.net.HttpURLConnection;

import android.util.Log;

import com.secondfloor.messages.CadastrarConsumidorRequest;
import com.secondfloor.messages.CadastrarConsumidorResponse;
import com.secondfloor.messages.LogonConsumidorRequest;
import com.secondfloor.messages.LogonConsumidorResponse;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class SegurancaService {
	private String urlServerBase;

	public SegurancaService(){
		urlServerBase ="http://10.0.2.2:8080/web/";
		//urlServerBase = "http://localhost:1886/Service.svc/web/";
	}
	
	public CadastrarConsumidorResponse CadastrarConsumidor(String email, String nome, String tipoAcesso)
	{
		final String route = "EncontrarOfertaPor";
		String uri = this.urlServerBase + route;
		CadastrarConsumidorResponse response = new CadastrarConsumidorResponse();
		CadastrarConsumidorRequest request = new CadastrarConsumidorRequest();
		request.setEmail(email);
		request.setNome(nome);
		//request.setTipoAcesso(tipoAcesso);
		
		JSONSerializer jsonSerializer = new JSONSerializer();
		String requestJson = jsonSerializer.exclude("*.class").deepSerialize(request);
		
		Log.i("uri", uri );
		Log.i("jsonRequest", requestJson );
		  
		try{
			CommunicationHelper communicationHelper = new CommunicationHelper();
			CommunicationPostResult postResult = communicationHelper.sendPost(uri, requestJson);
		    
		    if(postResult.getHttpResult() == HttpURLConnection.HTTP_OK)
		    {
		        JSONDeserializer<CadastrarConsumidorResponse> jsonDeserializer = new JSONDeserializer<CadastrarConsumidorResponse>();
		        jsonDeserializer.deserializeInto(postResult.getResponseJson(), response);
		    }
		}
		catch (Exception e) 
		{
			Log.e("SegurancaService.CadastrarConsumidorResponse", e.getMessage() );
			e.printStackTrace();
		}
		
		return response;
	}
	
	public LogonConsumidorResponse LogonConsumidor(String email,String senha)
	{
		final String route = "EncontrarOfertaPor";
		String uri = this.urlServerBase + route;
		LogonConsumidorResponse response = new LogonConsumidorResponse();
		LogonConsumidorRequest request = new LogonConsumidorRequest();
		request.setEmail(email);
		request.setSenha(senha);
		
		JSONSerializer jsonSerializer = new JSONSerializer();
		String requestJson = jsonSerializer.exclude("*.class").deepSerialize(request);
		
		Log.i("uri", uri );
		Log.i("jsonRequest", requestJson );
		  
		try{
			CommunicationHelper communicationHelper = new CommunicationHelper();
			CommunicationPostResult postResult = communicationHelper.sendPost(uri, requestJson);
		    
		    if(postResult.getHttpResult() == HttpURLConnection.HTTP_OK)
		    {
		        JSONDeserializer<LogonConsumidorResponse> jsonDeserializer = new JSONDeserializer<LogonConsumidorResponse>();
		        jsonDeserializer.deserializeInto(postResult.getResponseJson(), response);
		        
		    }
		}
		catch (Exception e) 
		{
			Log.e("SegurancaService.LogonConsumidor", e.getMessage() );
			e.printStackTrace();
		}
		return response;
	}

}
