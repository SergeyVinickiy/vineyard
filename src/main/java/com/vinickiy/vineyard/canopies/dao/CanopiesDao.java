package com.vinickiy.vineyard.canopies.dao;


import com.vinickiy.vineyard.model.entity.Canopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanopiesDao extends CrudRepository<Canopy, Long> {

}
