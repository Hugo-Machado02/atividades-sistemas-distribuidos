package br.com.hugomachadodev.calculadora_imc.dto;

public class ImcResponseDto {
    private double imc;
    private String classificacao;

    public ImcResponseDto(double imc, String classificacao) {
        this.imc = imc;
        this.classificacao = classificacao;
    }

    public double getImc() {
        return imc;
    }

    public String getClassificacao() {
        return classificacao;
    }
}