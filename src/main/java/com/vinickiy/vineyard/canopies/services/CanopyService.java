package com.vinickiy.vineyard.canopies.services;

import com.vinickiy.vineyard.canopies.dao.CanopiesDao;
import com.vinickiy.vineyard.model.dto.CanopyDto;
import com.vinickiy.vineyard.model.dto.RowDto;
import com.vinickiy.vineyard.model.entity.Canopy;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.vinickiy.vineyard.model.entity.CanopyStatus.GOOD;

@Service
public class CanopyService {

    private CanopiesDao canopiesDao;

    public CanopyService(CanopiesDao canopiesDao) {
        this.canopiesDao = canopiesDao;
    }

    public void createCanopiesForRow(RowDto rowDto) {

        int numberOfCanopies = rowDto.getCanopyAmountInRow();

        for (int k = 0; k < numberOfCanopies; k++) {
            Canopy newCanopy = Canopy.builder().rowNumber(rowDto.getRowNumber()).status(GOOD).build();
            canopiesDao.save(newCanopy);
        }

    }

    public Canopy createSingleCanopy(CanopyDto canopyDto){

        Canopy newCanopy = new Canopy();
        if(canopyDto.getStatus() != null){
            newCanopy.setStatus(canopyDto.getStatus());
        }
        else{newCanopy.setStatus(GOOD);}
        if(canopyDto.getComments() != null){
            newCanopy.setComments(canopyDto.getComments());
        }
        newCanopy.setRowNumber(canopyDto.getRowNumber());
        canopiesDao.save(newCanopy);
        return newCanopy;
    }


    public Canopy updateCanopy(Canopy canopy) {
//TODO  do it from here)
        Canopy canopyUpdated = canopy;


    }
}
