package com.andreea.Service;

import com.andreea.Controller.LandDTO;
import com.andreea.Repository.Peasant;
import com.andreea.Repository.PeasantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oana Bucurica on 8/1/2017.
 */
@Service
public class LandService {
    @Autowired
    PeasantRepository peasantRepository;

    public void addALand(int id, LandDTO landDTO) {
        Peasant peasant =peasantRepository.findOne(id);
        peasant.addLand(landDTO.dtoToEntity());
        peasantRepository.save(peasant);

    }
}
