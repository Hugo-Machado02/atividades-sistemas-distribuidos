package br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception;

public class NegativeAmountNotAllowedException extends RuntimeException{
    public NegativeAmountNotAllowedException() {
        super("Não é possível fazer a conversão de Valores Negativos");
    }
}
