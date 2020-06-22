package com.vinickiy.vineyard.model.dto;

import com.vinickiy.vineyard.model.entity.CanopyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CanopyDto extends BaseDto{

    @Enumerated(EnumType.STRING)
    private CanopyStatus status;
    private int rowNumber;
    private String comments;

}
