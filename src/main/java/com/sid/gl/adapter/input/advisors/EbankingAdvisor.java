package com.sid.gl.adapter.input.advisors;

import com.sid.gl.adapter.input.response.ApiResponse;
import com.sid.gl.exceptions.BadArgumentException;
import com.sid.gl.exceptions.CompteInexistantException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class EbankingAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception){
        ApiResponse<?> apiResponse = new ApiResponse<>();
        List<String> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    errors.add(fieldError.getDefaultMessage());
                });

        apiResponse.setStatus("FAILED");
        apiResponse.setMessages(errors);
        return apiResponse;
    }

    @ExceptionHandler(BadArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleServiceBussnessValidatorException(BadArgumentException exception){
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessages(Collections.singletonList(exception.getMessage()));
        response.setStatus("FAILED");
        return response;
    }

    @ExceptionHandler(CompteInexistantException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleServiceBussnessValidatorException(CompteInexistantException exception){
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessages(Collections.singletonList(exception.getMessage()));
        response.setStatus("FAILED");
        return response;
    }
}
