package com.vinickiy.vineyard.historyStatuses.dao;

import com.vinickiy.vineyard.model.entity.HistoryStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryStatusesDao extends CrudRepository<HistoryStatus, Long> {

    @Query(value = "SELECT h FROM HistoryStatus h WHERE canopyId = :canopyId")
    List<HistoryStatus> findStatusesByCanopyId(@Param("canopyId") long canopyId);
}
