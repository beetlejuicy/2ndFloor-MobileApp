package com.secondfloor.services;

public class CommunicationPostResult {
	private String responseJson;
	private int httpResult;

	public String getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(String responseJson) {
		this.responseJson = responseJson;
	}

	public int getHttpResult() {
		return httpResult;
	}

	public void setHttpResult(int httpResult) {
		this.httpResult = httpResult;
	}
}
