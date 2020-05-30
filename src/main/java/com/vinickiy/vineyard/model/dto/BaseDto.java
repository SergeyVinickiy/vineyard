package com.vinickiy.vineyard.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;


public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDateTime timeCreated;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDateTime timeUpdated;

}
