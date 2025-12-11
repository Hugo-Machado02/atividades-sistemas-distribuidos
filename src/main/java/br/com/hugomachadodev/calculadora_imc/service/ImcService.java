package br.com.hugomachadodev.calculadora_imc.service;

import br.com.hugomachadodev.calculadora_imc.dto.ImcResponseDto;
import br.com.hugomachadodev.calculadora_imc.validator.ImcValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImcService {

    @Autowired
    private ImcValidator validator;

    public ImcResponseDto calcularImc(double peso, double altura) {
        validator.validate(peso, altura);
        
        double imc = peso / (altura * altura);
        String classificacao = classificarImc(imc);
        
        return new ImcResponseDto(Math.round(imc * 100.0) / 100.0, classificacao);
    }

    public String obterClassificacao(double peso, double altura) {
        validator.validate(peso, altura);
        
        double imc = peso / (altura * altura);
        return classificarImc(imc);
    }

    private String classificarImc(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau I";
        } else if (imc < 40) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }
}