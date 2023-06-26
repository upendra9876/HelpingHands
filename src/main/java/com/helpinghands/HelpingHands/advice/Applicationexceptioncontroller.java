package com.helpinghands.HelpingHands.advice;

import com.helpinghands.HelpingHands.exception.EmailAlreadyexistException;
import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.exception.ValidIncidentidexception;
import jakarta.persistence.Lob;
import jakarta.transaction.RollbackException;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@Log4j2
@Log
@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class Applicationexceptioncontroller {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> getinvalidexception(MethodArgumentNotValidException exc){
        Map<String,String> errormap= new HashMap<>();
        exc.getBindingResult().getAllErrors().forEach((error)->{
           errormap.put(((FieldError) error).getField(),error.getDefaultMessage());

        });
        return errormap;
    }
    @ExceptionHandler(RollbackException.class)
    public Map<String,String> rollbackexception(RollbackException exc){
        Map<String,String> error = new HashMap<>();

        error.put("error_message", exc.getMessage());
        error.put("es","1");
        return error;
    }
    @ExceptionHandler(IllegalStateException.class)
    public Map<String,String> illegealstateexception(IllegalStateException exc){
        Map<String,String> error = new HashMap<>();

        error.put("error_message", exc.getMessage());
        error.put("es","1");
        return error;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyListException.class)
    public Map<String ,String> noactiveincidentexception(EmptyListException exc){
        Map<String ,String> errormap= new HashMap<>();

        errormap.put("errorMessage", exc.getMessage());
        errormap.put("es","1");
        return errormap;
    }
        @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> noSuchElementException(NoSuchElementException noSuchElementException){
        Map<String ,String> errormap= new HashMap<>();

        errormap.put("Error Message", noSuchElementException.getMessage());
        errormap.put("es","1");

        return errormap;
    }

    @ExceptionHandler(ValidIncidentidexception.class)
    public Map<String, String > validincidentidexception(ValidIncidentidexception exc){
        Map<String,String> error = new HashMap<>();

        error.put("error_message",exc.getMessage());
        error.put("es","1");
        return error;
    }

    @ExceptionHandler(EmailAlreadyexistException.class)
    public Map<String,String> emailalreadyexistexception(EmailAlreadyexistException exc){
        Map<String,String> error= new HashMap<>();
        error.put("error_message", exc.getMessage());
        error.put("es", "1");
        return error;
    }

    @ExceptionHandler(Exception.class)
    public Map<String,String> globalexception(Exception exc){
        Map<String,String> error= new HashMap<>();
       // error.put("exception_Name", exc.);
        error.put("error", String.valueOf(exc.getClass()));
        error.put("error_message", exc.getMessage());
        error.put("es", "1");
        return error;
    }



}
