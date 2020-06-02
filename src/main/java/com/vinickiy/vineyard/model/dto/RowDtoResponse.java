package com.vinickiy.vineyard.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RowDtoResponse {

    private List<RowDto> rowDto;

    public RowDtoResponse(List<RowDto> rowDto) {
        this.rowDto = rowDto;
    }

    public List<RowDto> getData() {
        if (Objects.isNull(rowDto))
            rowDto = new ArrayList<>();
        return rowDto;
    }

    public void setRowDto(List<RowDto> rowDto) {
        this.rowDto = rowDto;
    }
}
