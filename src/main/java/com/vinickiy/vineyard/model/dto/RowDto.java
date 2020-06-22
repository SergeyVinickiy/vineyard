package com.vinickiy.vineyard.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowDto extends BaseDto{


    private Integer rowNumber;
    //TODO should be changed to existing type + validation
    private String typeName;
    private int canopyAmountInRow;

}

