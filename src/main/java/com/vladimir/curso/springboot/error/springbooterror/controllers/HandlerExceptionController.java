package com.vladimir.curso.springboot.error.springbooterror.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.vladimir.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.vladimir.curso.springboot.error.springbooterror.models.Error;

@RestControllerAdvice                                                   //Esta mapeado a una excepcion en lugar de una url
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})                      // * Se le agrega {} cuando son mas separadas por coma
    public ResponseEntity<Error> divisionByZero(Exception ex){          // * El signo ResponseEntity<?> se pone cuando no se sabe 
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error dividiendo por 0");
        error.setMessage(ex.getMessage());                              // Este es mimso de la excepcion 
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());      // Es lo mismo que poner 500
        ////return ResponseEntity.internalServerError().body(error);  // Forma abreviada 
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error); 
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatError(NumberFormatException ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "numero invalido o incorrecto, no tiene formato de digito!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
    
    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundError(Exception ex){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "El usuario o role no existe!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
                                        //? 404 ^ */
    }

}
