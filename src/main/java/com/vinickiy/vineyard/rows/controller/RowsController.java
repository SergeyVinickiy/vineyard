package com.vinickiy.vineyard.rows.controller;

import com.vinickiy.vineyard.model.dto.RowDto;
import com.vinickiy.vineyard.model.entity.Row;
import com.vinickiy.vineyard.rows.services.RowsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
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
    public @ResponseBody
    List<Row> getAllRows(){
        return rowsService.findAllRows();
    }


}