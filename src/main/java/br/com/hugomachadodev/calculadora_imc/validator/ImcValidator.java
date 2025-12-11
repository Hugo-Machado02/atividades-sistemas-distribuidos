package br.com.hugomachadodev.calculadora_imc.validator;

import br.com.hugomachadodev.calculadora_imc.Exceptions.DivisionByZeroLikeException;
import br.com.hugomachadodev.calculadora_imc.Exceptions.InvalidHeightException;
import br.com.hugomachadodev.calculadora_imc.Exceptions.InvalidWeightException;
import org.springframework.stereotype.Component;

@Component
public class ImcValidator {

    public void validate(double peso, double altura) {
        validateWeight(peso);
        validateHeight(altura);
    }

    private void validateWeight(double peso) {
        if (peso <= 0) {
            throw new InvalidWeightException("Peso deve ser maior que zero");
        }
        if (peso < 2 || peso > 400) {
            throw new InvalidWeightException("Peso deve estar entre 2 e 400 kg");
        }
    }

    private void validateHeight(double altura) {
        if (altura == 0) {
            throw new DivisionByZeroLikeException("Altura não pode ser zero");
        }
        if (altura <= 0) {
            throw new InvalidHeightException("Altura deve ser maior que zero");
        }
        if (altura < 0.5 || altura > 2.5) {
            throw new InvalidHeightException("Altura deve estar entre 0.5 e 2.5 metros");
        }
    }
}