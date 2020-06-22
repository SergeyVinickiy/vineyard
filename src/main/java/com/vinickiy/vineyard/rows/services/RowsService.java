package com.vinickiy.vineyard.rows.services;

import com.vinickiy.vineyard.canopies.services.CanopyService;
import com.vinickiy.vineyard.model.dto.RowDto;
import com.vinickiy.vineyard.model.entity.Row;
import com.vinickiy.vineyard.rows.dao.RowsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class RowsService {

    private final RowsDao rowsDao;
    private final CanopyService canopyService;

    public RowsService(RowsDao rowsDao, CanopyService canopyService) {
        this.rowsDao = rowsDao;
        this.canopyService = canopyService;
    }


    @Transactional
    public @ResponseBody
    Row save(RowDto row) {
        Row newRow = Row.builder().vineType(row.getTypeName()).rowNumber(row.getRowNumber()).build();
        canopyService.createCanopiesForRow(row);
        return rowsDao.save(newRow); }


    public List<Row> findAllRows(){
        return (List<Row>) rowsDao.findAll();
    }

}
