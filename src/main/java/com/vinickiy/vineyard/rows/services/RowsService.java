package com.vinickiy.vineyard.rows.services;

import com.vinickiy.vineyard.model.entity.Row;
import com.vinickiy.vineyard.rows.dao.RowsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RowsService {

    private final RowsDao rowsDao;

    public RowsService(RowsDao rowsDao) {
        this.rowsDao = rowsDao;
    }


    @Transactional
    public Row save(Row row) {
        return rowsDao.save(row); }


    public List<Row> findAllRows(){
        return (List<Row>) rowsDao.findAll();
    }

}
