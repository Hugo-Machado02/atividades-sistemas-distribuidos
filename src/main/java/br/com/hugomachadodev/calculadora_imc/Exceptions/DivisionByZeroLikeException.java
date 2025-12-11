package br.com.hugomachadodev.calculadora_imc.Exceptions;

public class DivisionByZeroLikeException extends RuntimeException {
    public DivisionByZeroLikeException(String message) {
        super(message);
    }
}