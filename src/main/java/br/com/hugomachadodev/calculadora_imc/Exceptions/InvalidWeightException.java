package br.com.hugomachadodev.calculadora_imc.Exceptions;

public class InvalidWeightException extends RuntimeException {
    public InvalidWeightException(String message) {
        super(message);
    }
}