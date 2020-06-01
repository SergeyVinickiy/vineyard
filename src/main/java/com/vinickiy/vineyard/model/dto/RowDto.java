package com.vinickiy.vineyard.model.dto;


import com.vinickiy.vineyard.model.entity.VineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RowDto extends BaseDto{


    private Long id;
    private int rowNumber;
    private VineType typeName;

}

