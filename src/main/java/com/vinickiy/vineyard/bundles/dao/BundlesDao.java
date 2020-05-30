package com.vinickiy.vineyard.bundles.dao;

import com.vinickiy.vineyard.model.entity.Bundle;
import org.springframework.data.repository.CrudRepository;

public interface BundlesDao extends CrudRepository<Bundle, Long> {
}
