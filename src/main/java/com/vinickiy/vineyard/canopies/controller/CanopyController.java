package com.vinickiy.vineyard.canopies.controller;


import com.vinickiy.vineyard.canopies.services.CanopyService;
import com.vinickiy.vineyard.model.dto.CanopyDto;
import com.vinickiy.vineyard.model.entity.Canopy;
import com.vinickiy.vineyard.model.entity.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

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

    //TODO Should add search with row number and return relevant canopies by specific row
/*    @GetMapping
    @ResponseStatus(OK)
    public List<Canopy> getAllCanopies(int rowNumber){

        return canopyService.getAllCanopies(rowNumber);

    }*/

    @PutMapping
    @ResponseStatus(OK)
    public Canopy changeCanopyStatus(@Valid @RequestBody Canopy canopy){

        Canopy updatedCanopy = canopyService.updateCanopy(canopy);
        return updatedCanopy;
    }
}