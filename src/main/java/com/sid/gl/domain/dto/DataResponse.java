package com.sid.gl.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DataResponse {
    private List<?> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
