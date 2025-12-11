package br.com.hugomachadodev.calculadora_imc.Exceptions;

public class InvalidHeightException extends RuntimeException {
    public InvalidHeightException(String message) {
        super(message);
    }
}