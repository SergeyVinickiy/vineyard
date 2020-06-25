package com.vinickiy.vineyard.canopies.dao;


import com.vinickiy.vineyard.model.entity.Canopy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanopiesDao extends CrudRepository<Canopy, Long> {

    @Query(value = "SELECT c FROM Canopy c where rowNumber = :rowNumber")
    List<Canopy> findCanopiesByRowId(@Param("rowNumber") int rowNumber);

}