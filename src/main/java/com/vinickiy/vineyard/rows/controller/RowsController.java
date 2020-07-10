package com.vinickiy.vineyard.rows.controller;

import com.vinickiy.vineyard.model.dto.RowDto;
import com.vinickiy.vineyard.model.entity.Row;
import com.vinickiy.vineyard.rows.services.RowsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static org.springframework.http.HttpStatus.CREATED;


@Controller
@RequestMapping("vineyard/v1/rows")
public class RowsController {

    private final RowsService rowsService;

    public RowsController(RowsService rowsService) {
        this.rowsService = rowsService;
    }


    @PostMapping("/new")
    @ResponseStatus(CREATED)
    public @ResponseBody Row createNewRow(@Valid @RequestBody RowDto row) {

        Row savedRow = rowsService.save(row);
        return savedRow;

    }


    @GetMapping
    public
    String getAllRows(Model model){
        model.addAttribute("rows", rowsService.findAllRows());
        return "allRows.html";
    }


}