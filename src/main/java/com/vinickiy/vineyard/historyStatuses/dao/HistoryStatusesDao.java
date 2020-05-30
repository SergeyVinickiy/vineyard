package com.vinickiy.vineyard.historyStatuses.dao;

import com.vinickiy.vineyard.model.entity.HistoryStatus;
import org.springframework.data.repository.CrudRepository;

public interface HistoryStatusesDao extends CrudRepository<HistoryStatus, Long> {
}
