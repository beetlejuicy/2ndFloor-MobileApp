/**
 * EncontrarOfertaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.secondfloor.messages;

public class EncontrarOfertaResponse  implements java.io.Serializable {
    private java.lang.String message;

    private com.secondfloor.dto.OfertaDTO[] ofertas;

    private java.lang.Boolean success;

    public EncontrarOfertaResponse() {
    }

    public EncontrarOfertaResponse(
           java.lang.String message,
           com.secondfloor.dto.OfertaDTO[] ofertas,
           java.lang.Boolean success) {
           this.message = message;
           this.ofertas = ofertas;
           this.success = success;
    }


    /**
     * Gets the message value for this EncontrarOfertaResponse.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this EncontrarOfertaResponse.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the ofertas value for this EncontrarOfertaResponse.
     * 
     * @return ofertas
     */
    public com.secondfloor.dto.OfertaDTO[] getOfertas() {
        return ofertas;
    }


    /**
     * Sets the ofertas value for this EncontrarOfertaResponse.
     * 
     * @param ofertas
     */
    public void setOfertas(com.secondfloor.dto.OfertaDTO[] ofertas) {
        this.ofertas = ofertas;
    }


    /**
     * Gets the success value for this EncontrarOfertaResponse.
     * 
     * @return success
     */
    public java.lang.Boolean getSuccess() {
        return success;
    }


    /**
     * Sets the success value for this EncontrarOfertaResponse.
     * 
     * @param success
     */
    public void setSuccess(java.lang.Boolean success) {
        this.success = success;
    }
}
