package com.vinickiy.vineyard.canopies.services;

import com.vinickiy.vineyard.canopies.dao.CanopiesDao;
import com.vinickiy.vineyard.historyStatuses.HServices.HStatusesService;
import com.vinickiy.vineyard.model.dto.CanopyDto;
import com.vinickiy.vineyard.model.dto.RowDto;
import com.vinickiy.vineyard.model.entity.Canopy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.vinickiy.vineyard.model.entity.CanopyStatus.GOOD;

@Service
public class CanopyService {

    private final CanopiesDao canopiesDao;
    private final HStatusesService hService;

    public CanopyService(CanopiesDao canopiesDao, HStatusesService hService) {
        this.canopiesDao = canopiesDao;
        this.hService = hService;
    }

    public void createCanopiesForRow(RowDto rowDto) {

        int numberOfCanopies = rowDto.getCanopyAmountInRow();

        for (int k = 0; k < numberOfCanopies; k++) {
            Canopy newCanopy = Canopy.builder().rowNumber(rowDto.getRowNumber()).status(GOOD).build();
            canopiesDao.save(newCanopy);
        }

    }

    public Canopy createSingleCanopy(CanopyDto canopyDto) {

        Canopy newCanopy = new Canopy();
        if (canopyDto.getStatus() != null) {
            newCanopy.setStatus(canopyDto.getStatus());
        } else {
            newCanopy.setStatus(GOOD);
        }
        if (canopyDto.getComments() != null) {
            newCanopy.setComments(canopyDto.getComments());
        }
        newCanopy.setRowNumber(canopyDto.getRowNumber());
        canopiesDao.save(newCanopy);
        return newCanopy;
    }


    public Canopy updateCanopy(Canopy canopy) {
        Optional<Canopy> canopyForUpdate = canopiesDao.findById(canopy.getId());

        if (!canopyForUpdate.isPresent()) {
            throw new IllegalArgumentException("Canopy wasn't found");
        }

        canopyForUpdate.get().setStatus(canopy.getStatus());
        canopyForUpdate.get().setComments(canopy.getComments());
        hService.statusChange(canopy);
        return canopiesDao.save(canopyForUpdate.get());

    }

    public List<Canopy> getCanopiesByRow(int rowNumber) {
        return canopiesDao.findCanopiesByRowId(rowNumber);
    }

    public void deleteCanopyById(long canopyId) {
        canopiesDao.deleteById(canopyId);
    }

    public void saveImage(long canopyId, byte[] image){
        Optional<Canopy> canopyToAddImage = canopiesDao.findById(canopyId);

        if (!canopyToAddImage.isPresent()) {
            throw new IllegalArgumentException("Canopy wasn't found");
        }

        canopyToAddImage.get().setImage(image);
        canopiesDao.save(canopyToAddImage.get());

    }

}
