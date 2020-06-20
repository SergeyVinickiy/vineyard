package com.vinickiy.vineyard.vineType.services;

import com.vinickiy.vineyard.model.entity.VineType;
import com.vinickiy.vineyard.vineType.dao.VineTypeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    public void deleteTypeById(Long id) {
        vineTypeDao.deleteById(id);
    }
}
