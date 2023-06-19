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
    public Map<String,String> nosuchelementexception(NoSuchElementException exc){
        Map<String ,String> errormap= new HashMap<>();

        errormap.put("Error Message",exc.getMessage());
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

}
