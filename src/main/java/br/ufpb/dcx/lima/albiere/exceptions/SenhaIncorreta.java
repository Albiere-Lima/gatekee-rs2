package br.ufpb.dcx.lima.albiere.exceptions;

public class SenhaIncorreta extends RuntimeException {
    public SenhaIncorreta(String message) {
        super(message);
    }
}
