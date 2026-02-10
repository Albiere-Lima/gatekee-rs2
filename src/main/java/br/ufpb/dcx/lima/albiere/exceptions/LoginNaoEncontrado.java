package br.ufpb.dcx.lima.albiere.exceptions;

public class LoginNaoEncontrado extends RuntimeException {
    public LoginNaoEncontrado(String message) {
        super(message);
    }
}
