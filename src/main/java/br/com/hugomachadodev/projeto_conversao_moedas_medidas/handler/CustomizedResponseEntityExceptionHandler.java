package br.com.hugomachadodev.projeto_conversao_moedas_medidas.handler;

import java.util.Date;

import org.springframework.core.convert.ConversionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.ConversionRateNotFoundException;
import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.ExceptionResponse;
import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.NegativeAmountNotAllowedException;
import br.com.hugomachadodev.projeto_conversao_moedas_medidas.exception.UnsupportedUnitException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(ConversionException.class)
    public final ResponseEntity<ExceptionResponse> handleConversionExceptions(ConversionException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ConversionRateNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleConversionRateNotFoundExceptions(ConversionRateNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(NegativeAmountNotAllowedException.class)
    public final ResponseEntity<ExceptionResponse> handleNegativeAmountNotAllowedExceptions(NegativeAmountNotAllowedException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(UnsupportedUnitException.class)
    public final ResponseEntity<ExceptionResponse> handleUnsupportedUnitExceptions(UnsupportedUnitException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}