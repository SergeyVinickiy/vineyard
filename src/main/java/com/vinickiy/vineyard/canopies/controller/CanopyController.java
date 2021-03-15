package com.vinickiy.vineyard.canopies.controller;


import com.vinickiy.vineyard.canopies.services.CanopyService;
import com.vinickiy.vineyard.errors.MissingEntityException;
import com.vinickiy.vineyard.model.dto.CanopiesByRowRequest;
import com.vinickiy.vineyard.model.dto.CanopyDto;
import com.vinickiy.vineyard.model.entity.Canopy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
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


    @GetMapping
    @ResponseStatus(OK)
    public @ResponseBody List<Canopy> getAllCanopies(@Valid @RequestBody CanopiesByRowRequest request){
    try{
        return canopyService.getCanopiesByRow(request.getRowNumber());
    }
        catch(NullPointerException e)
        {
        throw new MissingEntityException();
    }
    }


    @PutMapping
    @ResponseStatus(OK)
    public @ResponseBody Canopy changeCanopyStatus(@Valid @RequestBody Canopy canopy){

        try{
        return canopyService.updateCanopy(canopy);
        }
        catch(NullPointerException e){
            throw new MissingEntityException();
        }

    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteCanopy(@RequestParam(name = "canopyId") long canopyId){
        canopyService.deleteCanopyById(canopyId);
    }

    @PostMapping("/imageUpload")
    @ResponseStatus(NO_CONTENT)
    public void uploadPictureForCanopy(@RequestParam(name = "canopyId") long canopyId, @RequestParam("file") MultipartFile file) {

        byte[] image = new byte[0];
        try {
            image = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        canopyService.saveImage(canopyId, image);

    }

}
