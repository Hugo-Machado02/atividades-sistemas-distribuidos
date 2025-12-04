package br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception;

public class ConversionRateNotFoundException extends RuntimeException{
    public ConversionRateNotFoundException(String unitType) {
        super("Não foi possível encontrar a taxa de conversão para o parametro informado" + unitType);
    }
}
