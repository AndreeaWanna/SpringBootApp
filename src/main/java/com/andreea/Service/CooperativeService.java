package com.andreea.Service;

import com.andreea.Controller.CooperativeDTO;
import com.andreea.Controller.PeasantDTO;
import com.andreea.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Oana Bucurica on 8/2/2017.
 */
@Service
public class CooperativeService {
    @Autowired
    PeasantRepository peasantRepository;
    @Autowired
    LandRepository landRepository;
    @Autowired
    CooperativeRepository cooperativeRepository;


    public CooperativeDTO getCooperative(int id){
        CooperativeDTO cooperativeDTO = cooperativeRepository.findOne(id).entityToDto();
        return cooperativeDTO;
    }

    public void addCooperative(CooperativeDTO cooperativeDTO) {

        cooperativeRepository.save(cooperativeDTO.dtoToEntity());
    }


}



