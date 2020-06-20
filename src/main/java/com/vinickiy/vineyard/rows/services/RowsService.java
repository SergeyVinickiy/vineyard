package com.vinickiy.vineyard.rows.services;

import com.vinickiy.vineyard.model.entity.Row;
import com.vinickiy.vineyard.rows.dao.RowsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class RowsService {

    private final RowsDao rowsDao;
    private final BundleService bundleService;

    public RowsService(RowsDao rowsDao, BundleService bundleService) {
        this.rowsDao = rowsDao;
        this.bundleService = bundleService;
    }


    @Transactional
    public @ResponseBody
    Row save(Row row) {
        bundleService.save(row);
        return rowsDao.save(row); }


    public List<Row> findAllRows(){
        return (List<Row>) rowsDao.findAll();
    }

}
