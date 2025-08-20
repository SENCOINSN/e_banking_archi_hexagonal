package com.sid.gl.adapter.input.rest;

import com.sid.gl.adapter.input.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AbstractController {
    public static final String SUCCESS = "SUCCESS";

    public <T> ResponseEntity<ApiResponse> getResponseEntity(T response) {
        ApiResponse<T> responseDTO = ApiResponse
                .<T>builder()
                .status(SUCCESS)
                .data(response)
                .build();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
