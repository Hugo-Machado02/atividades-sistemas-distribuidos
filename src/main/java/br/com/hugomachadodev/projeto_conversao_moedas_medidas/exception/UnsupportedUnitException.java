package br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception;

public class UnsupportedUnitException extends RuntimeException{
    public UnsupportedUnitException(String unitType) {
        super("Nao é possível fazer a conversão! Parametro " + unitType + " Não encontrado");
    
    }
    public UnsupportedUnitException(String typeCoin, String unitType) {
        super("Nao é possível fazer a conversão! " + typeCoin + " - " + unitType + " nao suportada");
    }
}
