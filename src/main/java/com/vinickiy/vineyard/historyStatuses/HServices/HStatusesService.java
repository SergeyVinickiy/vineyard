package com.vinickiy.vineyard.historyStatuses.HServices;

import com.vinickiy.vineyard.historyStatuses.dao.HistoryStatusesDao;
import com.vinickiy.vineyard.model.entity.Canopy;
import com.vinickiy.vineyard.model.entity.HistoryStatus;
import org.springframework.stereotype.Service;

@Service
public class HStatusesService {

    private HistoryStatusesDao dao;

    public HStatusesService(HistoryStatusesDao dao) {
        this.dao = dao;
    }

    public void statusChange(Canopy canopy){
        HistoryStatus newHStatus = HistoryStatus.builder()
                .canopyId(canopy.getId()).newStatus(canopy.getStatus()).comments(canopy.getComments()).build();
        dao.save(newHStatus);

    }

}
