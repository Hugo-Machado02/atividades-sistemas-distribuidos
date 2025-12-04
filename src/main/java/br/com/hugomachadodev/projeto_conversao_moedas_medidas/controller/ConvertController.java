package br.com.hugomachadodev.projeto_conversao_moedas_medidas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.hugomachadodev.projeto_conversao_moedas_medidas.service.OperationConvert;
import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.UnsupportedUnitException;

@RestController
public class ConvertController {
    public OperationConvert OperationConvert = new OperationConvert();
    
    @RequestMapping(value = "convert/coin")
    public String convertCoin(
        @RequestParam (value = "from") String fromCoin,
        @RequestParam (value = "to") String toCoin, 
        @RequestParam (value = "value") double valueCoin 
    ) throws Exception{
        if(fromCoin.equals("")) throw new UnsupportedUnitException("fromCoin");
        if(toCoin.equals("")) throw new UnsupportedUnitException("toCoin");
        double valueOperation = OperationConvert.operationCoins(fromCoin, toCoin, valueCoin);
        return String.format("%s %.2f = %s %.", fromCoin, valueCoin, toCoin, valueOperation);
    }

    @RequestMapping(value = "convert/distance")
    public String convertDistance(
        @RequestParam (value = "from") String fromDistance,
        @RequestParam (value = "value") double valueDistance
    ) throws Exception{
        if(fromDistance.equals("")) throw new UnsupportedUnitException("valueDistance");
        System.out.println(valueDistance);
        String valueOperation = OperationConvert.operationDistance(fromDistance, valueDistance);
        
        return String.format("%.4f %s = %s", valueDistance, fromDistance.toUpperCase(), valueOperation);
    }

    @RequestMapping(value = "convert/temperature")
    public String convertTemperature(
        @RequestParam (value = "from") String fromTemperature,
        @RequestParam (value = "value") double valueTemperature
    ) throws Exception{
        if(fromTemperature.equals("")) throw new UnsupportedUnitException("fromTemperature");
        System.out.println(valueTemperature);
        String valueOperation = OperationConvert.operationTemperature(fromTemperature, valueTemperature);
        
        return String.format("%.2f º%s = %s", valueTemperature, fromTemperature.toUpperCase(), valueOperation);
    }
}
