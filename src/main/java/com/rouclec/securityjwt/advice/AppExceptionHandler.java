package com.rouclec.securityjwt.advice;

import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgurement(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> handleNotFoundException(NoSuchElementException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", "Value not found");
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);
        Map<String, String> errorMap = new HashMap<>();

        System.out.println("Root message ====== " + rootCause.getMessage());
        System.out.println("localized message ===== " + rootCause.getLocalizedMessage());
        System.out.println("cause ===== " + rootCause.getCause());
        System.out.println("cause contains ===== " + rootCause.getMessage().contains("duplicate"));


        if (rootCause.getMessage().contains("duplicate key value violates unique constraint \"users_email_key\"")) {
            String localizedMessage = rootCause.getLocalizedMessage();
            String errorMessage = "User with email "
                    + localizedMessage.substring(localizedMessage.lastIndexOf("(") + 1, localizedMessage.lastIndexOf(")"))
                    + " already exists";
            errorMap.put("message", errorMessage);
        }else {
            // Handle other cases or return a generic error message
            String errorMessage = "An error occurred.";
            errorMap.put("message",errorMessage);
        }



        return errorMap;
    }


}
