/**
 * AtribuirRatingOfertaRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.secondfloor.messages;

public class AtribuirRatingOfertaRequest  implements java.io.Serializable {
    private java.lang.String rating;
    private java.lang.String consumidorId;
    private java.lang.String produtoId;

    public AtribuirRatingOfertaRequest() {
    }

    public AtribuirRatingOfertaRequest(
           java.lang.String rating) {
           this.rating = rating;
    }


    /**
     * Gets the rating value for this AtribuirRatingOfertaRequest.
     * 
     * @return rating
     */
    public java.lang.String getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this AtribuirRatingOfertaRequest.
     * 
     * @param rating
     */
    public void setRating(java.lang.String rating) {
        this.rating = rating;
    }

	public java.lang.String getConsumidorId() {
		return consumidorId;
	}

	public void setConsumidorId(java.lang.String consumidorId) {
		this.consumidorId = consumidorId;
	}

	public java.lang.String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(java.lang.String produtoId) {
		this.produtoId = produtoId;
	}
}
