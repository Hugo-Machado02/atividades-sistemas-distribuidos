package br.com.hugomachadodev.projeto_conversao_moedas_medidas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.NegativeAmountNotAllowedException;
import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.UnsupportedUnitException;
import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.ConversionRateNotFoundException;

public class OperationConvert {
    private static final Map<String, Double> taxasCoin = new HashMap<>();
    private static final ArrayList<String> supportedDistances = new ArrayList<String>();
    private static final ArrayList<String> supportedTemperatures = new ArrayList<String>();
    private static final double factorDistance = 1.609344;
    private static final double factorTemperature = 1.8;
    
    public OperationConvert() {
        taxasCoin.put("USD", 1.0);
        taxasCoin.put("BRL", 5.33);
        taxasCoin.put("EUR", 0.86);
        supportedDistances.add("km");
        supportedDistances.add("mi");
        supportedTemperatures.add("C");
        supportedTemperatures.add("F");
    }

    public double operationCoins(String fromConvert, String toConvert, double valueConvert){
        Double taxaFrom = taxasCoin.get(fromConvert.toUpperCase());
        Double taxaTo = taxasCoin.get(toConvert.toUpperCase());
        if (taxaFrom == null) {
            throw new ConversionRateNotFoundException(fromConvert);
        }
        if (taxaTo == null) {
            throw new ConversionRateNotFoundException(toConvert);
        }

        isPositive(valueConvert);;
        return valueConvert * (taxaTo / taxaFrom);
    }

    public String operationDistance(String fromConvert, double valueConvert){
        if(!supportedDistances.contains(fromConvert)) {
            throw new UnsupportedUnitException(fromConvert);
        }

        isPositive(valueConvert);
        String str_value = "";

        if(fromConvert.toLowerCase().equals("km")) {
            double value = valueConvert / factorDistance;
            str_value = String.format(("%4f MI"), value);
        } else {
            double value = valueConvert * factorDistance;
            str_value = String.format(("%4f KM"), value);
        }

        return str_value;
    }
    
    public String operationTemperature(String fromConvert, double valueConvert){
        if(!supportedTemperatures.contains(fromConvert.toUpperCase())) {
            throw new UnsupportedUnitException(fromConvert);
        }

        isPositive(valueConvert);

        
        String str_value = "";
        if(fromConvert.toUpperCase().equals("C")) {
            double value = (valueConvert * factorTemperature) + 32;
            str_value = String.format(("%.2f ºF"), value);
        } else {
            double value = (valueConvert - 32) / factorTemperature;
            str_value = String.format(("%.2f ºC"), value);
        }

        return str_value;
    }

    private boolean isPositive(double value) {
        if(value > 0) {
            return true;
        } else {
            throw new NegativeAmountNotAllowedException();
        }
    }
}