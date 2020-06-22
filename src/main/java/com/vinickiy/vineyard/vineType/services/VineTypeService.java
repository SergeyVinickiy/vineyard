package com.vinickiy.vineyard.vineType.services;

import com.vinickiy.vineyard.model.entity.VineType;
import com.vinickiy.vineyard.vineType.dao.VineTypeDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class VineTypeService {

    private final VineTypeDao vineTypeDao;

    public VineTypeService(VineTypeDao vineTypeDao) {
        this.vineTypeDao = vineTypeDao;
    }

    @Transactional
    public VineType save(String vineType) {
        VineType newType = VineType.builder().vineType(vineType).build();
        return vineTypeDao.save(newType);
    }

    public List<VineType> findAllRows() {
        return (List<VineType>) vineTypeDao.findAll();
    }


    public String deleteTypeById(Long id) {
        try {
            vineTypeDao.deleteById(id);
            return "Deleted Successfully.Id: " + id;
        } catch (EmptyResultDataAccessException e) {
            log.debug("Type not found for deleting. Id: " + id);
            return "Vine type not found. Id: " + id;
        }
    }
}
