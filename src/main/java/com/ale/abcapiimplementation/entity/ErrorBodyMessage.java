package com.ale.abcapiimplementation.entity;

public class ErrorBodyMessage {
    String codigo;
    String error;

    public ErrorBodyMessage(String codigo, String error) {
        this.codigo = codigo;
        this.error = error;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
