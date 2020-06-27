package com.vinickiy.vineyard.historyStatuses.controller;

import com.vinickiy.vineyard.historyStatuses.dao.HistoryStatusesDao;
import com.vinickiy.vineyard.model.entity.HistoryStatus;
import com.vinickiy.vineyard.model.entity.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("vineyard/v1/hstatus")
public class HStatusController {

    private HistoryStatusesDao historyStatusesDao;

    public HStatusController(HistoryStatusesDao historyStatusesDao) {
        this.historyStatusesDao = historyStatusesDao;
    }

    @GetMapping
    public @ResponseBody
    List<HistoryStatus> getCanopyStatusById(@RequestParam(name = "id") long id){
        return historyStatusesDao.findStatusesByCanopyId(id);
    }

}
