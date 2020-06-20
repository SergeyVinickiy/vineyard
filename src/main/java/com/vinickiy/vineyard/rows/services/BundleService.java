package com.vinickiy.vineyard.rows.services;


import com.vinickiy.vineyard.bundles.dao.BundlesDao;
import com.vinickiy.vineyard.model.entity.Bundle;
import com.vinickiy.vineyard.model.entity.Row;
import org.springframework.stereotype.Service;

@Service
public class BundleService {

    private BundlesDao bundlesDao;

    public BundleService(BundlesDao bundlesDao) {
        this.bundlesDao = bundlesDao;
    }

    public void save(Row row) {

        //TODO add check if exist
        Bundle bundle = Bundle.builder().row(row).build();
        bundlesDao.save(bundle);
    }

}
