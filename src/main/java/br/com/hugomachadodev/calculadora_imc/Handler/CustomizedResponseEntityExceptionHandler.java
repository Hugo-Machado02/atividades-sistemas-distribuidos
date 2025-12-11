package br.com.hugomachadodev.calculadora_imc.Handler;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.hugomachadodev.calculadora_imc.Exceptions.ExceptionResponse;
import br.com.hugomachadodev.calculadora_imc.Exceptions.UnsupportedMathOperationException;
import br.com.hugomachadodev.calculadora_imc.Exceptions.InvalidHeightException;
import br.com.hugomachadodev.calculadora_imc.Exceptions.InvalidWeightException;
import br.com.hugomachadodev.calculadora_imc.Exceptions.DivisionByZeroLikeException;

import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    };

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidHeightException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidHeightException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidWeightException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidWeightException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DivisionByZeroLikeException.class)
    public final ResponseEntity<ExceptionResponse> handleDivisionByZeroLikeException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
