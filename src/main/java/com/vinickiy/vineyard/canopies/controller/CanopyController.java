package com.vinickiy.vineyard.canopies.controller;


import com.vinickiy.vineyard.canopies.services.CanopyService;
import com.vinickiy.vineyard.model.dto.CanopyDto;
import com.vinickiy.vineyard.model.entity.Canopy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping("vineyard/v1/canopies")
public class CanopyController {

    private final CanopyService canopyService;

    public CanopyController(CanopyService canopyService) {
        this.canopyService = canopyService;
    }

    @PostMapping("/new")
    @ResponseStatus(CREATED)
    public @ResponseBody
    Canopy createSingleCanopy(@Valid @RequestBody CanopyDto canopyDto) {

        Canopy newCanopy = canopyService.createSingleCanopy(canopyDto);
        return newCanopy;

    }
}
