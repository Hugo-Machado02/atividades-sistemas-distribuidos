package br.com.hugomachadodev.calculadora_imc.controller;

import br.com.hugomachadodev.calculadora_imc.dto.ImcResponseDto;
import br.com.hugomachadodev.calculadora_imc.service.ImcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imc")
public class ImcController {

    @Autowired
    private ImcService imcService;

    @GetMapping
    public ResponseEntity<ImcResponseDto> calcularImc(
            @RequestParam double peso,
            @RequestParam double altura) {
        
        ImcResponseDto response = imcService.calcularImc(peso, altura);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/classificacao")
    public ResponseEntity<String> obterClassificacao(
            @RequestParam double peso,
            @RequestParam double altura) {
        
        String classificacao = imcService.obterClassificacao(peso, altura);
        return ResponseEntity.ok(classificacao);
    }
}