package com.andreea.Service;

import com.andreea.Controller.PeasantDTO;
import com.andreea.Repository.LandRepository;
import com.andreea.Repository.Peasant;
import com.andreea.Repository.PeasantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oana Bucurica on 7/26/2017.
 */
@Service
public class PeasantService {

    @Autowired
    PeasantRepository peasantRepository;
    @Autowired
    LandRepository landRepository;

    public static Peasant peasant;

    public PeasantDTO getPeasant(int id){
      PeasantDTO peasantDTO = peasantRepository.findOne(id).entityToDto();
      return peasantDTO;
    }

    public  void deleteLand(int id) {
        landRepository.delete(id);
    }
    public void deletePeasant(int id){
        landRepository.delete(id);

    }

    public void addPeasant(PeasantDTO peasantDTO) {
        Peasant peasant = peasantDTO.dtoToEntity();
        peasantRepository.save(peasant);
    }
}
