package com.sid.gl.adapter.input.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class ApiResponse<T> {
    private T data;
    private List<String> messages;
    private String status;
}
