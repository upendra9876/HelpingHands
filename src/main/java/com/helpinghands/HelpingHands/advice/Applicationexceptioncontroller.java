package com.helpinghands.HelpingHands.advice;

import com.helpinghands.HelpingHands.exception.EmptyListException;
import com.helpinghands.HelpingHands.exception.ValidIncidentidexception;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

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
    @ExceptionHandler(IllegalStateException.class)
    public Map<String,String> illegealstateexception(IllegalStateException exc){
        Map<String,String> error = new HashMap<>();
        error.put("error_message", exc.getMessage());
        return error;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EmptyListException.class)
    public String noactiveincidentexception(EmptyListException exc){
        return exc.getMessage();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> nosuchelementexception(NoSuchElementException exc){
        Map<String ,String> errormap= new HashMap<>();
        errormap.put("Error Message",exc.getLocalizedMessage());
        return errormap;
    }

    @ExceptionHandler(ValidIncidentidexception.class)
    public Map<String, String > validincidentidexception(ValidIncidentidexception exc){
        Map<String,String> error = new HashMap<>();
        error.put("error_message",exc.getMessage());
        return error;
    }

}
