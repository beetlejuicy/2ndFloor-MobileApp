package com.secondfloor.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.secondfloor.messages.EncontrarOfertaResponse;

import flexjson.JSONDeserializer;

import android.util.Log;

public class CommunicationHelper {
	
	public CommunicationPostResult sendPost(String uri, String requestJson)
	{
		CommunicationPostResult res = new CommunicationPostResult();
		
		HttpURLConnection urlConnection=null;
		try
		{
			URL url = new URL(uri);  
		    urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setDoOutput(true);   
		    urlConnection.setRequestMethod("POST");  
		    urlConnection.setUseCaches(false);  
		    urlConnection.setConnectTimeout(10000);  
		    urlConnection.setReadTimeout(10000);  
		    urlConnection.setRequestProperty("Content-Type","application/json; charset=utf-8");	
		    
		    DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
		    wr.writeBytes(requestJson);
		    wr.flush();
		    wr.close();
		    
		    res.setHttpResult(urlConnection.getResponseCode());
		    
		    Log.i("HttpResult", String.valueOf(res.getHttpResult()));
		    
		    if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
		    {
		    	InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
		    	
		    	BufferedReader br = new BufferedReader(reader);
		    	
		    	StringBuilder sb = new StringBuilder();
		    	String line = null;
		        while ((line = br.readLine()) != null) 
		        {  
		            sb.append(line + "\n");  
		        }
		        br.close();
		        
		        res.setResponseJson(sb.toString());
		        Log.i("responseJson", res.getResponseJson());
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
		
		return res;
	}
}
