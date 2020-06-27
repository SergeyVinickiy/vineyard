package com.vinickiy.vineyard.rows.dao;

import com.vinickiy.vineyard.model.entity.Row;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface RowsDao extends CrudRepository<Row, Long> {

    @Query(value = "SELECT r FROM Row r where rowNumber = :rowNumber")
    Row findRow(@Param("rowNumber") Integer rowNumber);
}
