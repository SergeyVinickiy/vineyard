package com.vinickiy.vineyard.vineType.controller;

import com.vinickiy.vineyard.model.dto.VineTypeRequestDto;
import com.vinickiy.vineyard.model.entity.VineType;
import com.vinickiy.vineyard.vineType.services.VineTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping("vineyard/v1/vineType")
public class VineTypeController {

    private final VineTypeService vineTypeService;

    public VineTypeController(VineTypeService vineTypeService) {
        this.vineTypeService = vineTypeService;
    }


    @PostMapping("/new")
    @ResponseStatus(CREATED)
    public @ResponseBody
    VineType createNewRow(@RequestBody VineTypeRequestDto vineTypeRequestDto) {
        return vineTypeService.save(vineTypeRequestDto.getVineType());
    }


    @GetMapping
    public @ResponseBody
    List<VineType> getAllRows() {
        return vineTypeService.findAllRows();
    }

    @DeleteMapping
    public void deleteById(@RequestParam(name = "id") long id) {
        vineTypeService.deleteTypeById(id);
    }

}
