package com.secondfloor.servicesRest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.util.Log;

import com.secondfloor.messages.EncontrarOfertaRequest;
import com.secondfloor.messages.EncontrarOfertaResponse;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class AnuncioRest {
	private String urlServerBase;
	
	public void AnuncioRest()
	{
		urlServerBase ="http://localhost:8080/web/";
		//urlServerBase = "http://localhost:1886/Service.svc/web/";
	}
	
	public EncontrarOfertaResponse EncontrarOfertasPorNomeProduto(String nomeProduto)
	{
		urlServerBase ="http://10.0.2.2:8080/web/";
		//urlServerBase = "http://localhost:1886/Service.svc/web/";
		
		final String route = "EncontrarOfertaPor";
		String uri = this.urlServerBase + route;
		
		EncontrarOfertaResponse response = new EncontrarOfertaResponse();
		StringBuilder sb = new StringBuilder(); 
		
		EncontrarOfertaRequest request = new EncontrarOfertaRequest();
		request.setProduto(nomeProduto);
		//request.setBairro("bairro");
		//request.setTipoProduto("tipoProduto");
		
		//flexjson
		JSONSerializer jsonSerializer = new JSONSerializer();
		String requestStr = jsonSerializer.exclude("*.class").deepSerialize(request);
		
		Log.i("uri", uri );
		Log.i("jsonRequest", requestStr );
				
		HttpURLConnection urlConnection=null;  
		try{
			//Connexao
			URL url = new URL(uri);  
		    urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setDoOutput(true);   
		    urlConnection.setRequestMethod("POST");  
		    urlConnection.setUseCaches(false);  
		    urlConnection.setConnectTimeout(10000);  
		    urlConnection.setReadTimeout(10000);  
		    urlConnection.setRequestProperty("Content-Type","application/json; charset=utf-8");	
		    
		    DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
		    wr.writeBytes(requestStr);
		    wr.flush();
		    wr.close();
		    
		    int HttpResult = urlConnection.getResponseCode();
		    Log.i("HttpResult", String.valueOf(HttpResult));
		    if(HttpResult == HttpURLConnection.HTTP_OK)
		    {
		    	InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
		    	
		    	BufferedReader br = new BufferedReader(reader);
		    	
		    	String line = null;
		        while ((line = br.readLine()) != null) 
		        {  
		            sb.append(line + "\n");  
		        }
		        br.close();
		        
		        //flexjson
		        JSONDeserializer<EncontrarOfertaResponse> jsonDeserializer = new JSONDeserializer<EncontrarOfertaResponse>();
		        jsonDeserializer.deserializeInto(sb.toString(), response);
		        Log.i("responseJson", sb.toString());
		    }
		} 
		catch(MalformedURLException e)
		{
			Log.e("MalformedURLException", e.getMessage() );
			e.printStackTrace();  
		} 
		catch (ProtocolException e) 
		{
			Log.e("ProtocolException", e.getMessage() );
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			Log.e("IOException", e.getMessage() );
			e.printStackTrace();
		}
		finally{  
		    if(urlConnection!=null)  
		        urlConnection.disconnect();  
		}
		
		return response;
	}

}
