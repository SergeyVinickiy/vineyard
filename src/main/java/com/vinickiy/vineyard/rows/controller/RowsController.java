package com.vinickiy.vineyard.rows.controller;

import com.vinickiy.vineyard.model.entity.Row;
import com.vinickiy.vineyard.rows.services.RowsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public String createNewRow(@Valid @RequestBody Row Row, BindingResult result) {

        Row savedRow = rowsService.save(Row);
        return "redirect:/rows/" + savedRow.getId();


    }
}