package com.andreea.Controller;

import com.andreea.Service.CooperativeService;
import com.andreea.Service.LandService;
import com.andreea.Service.PeasantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oana Bucurica on 7/26/2017.
 */

@RestController
@RequestMapping ("/peasant")
public class PeasantController {
    @Autowired
    private PeasantService peasantService;
    @Autowired
    private LandService landService;
    @Autowired
    private CooperativeService cooperativeService;

    private static Logger logger = LoggerFactory.getLogger(PeasantController.class);

    @RequestMapping(value = "/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addPeasant(@PathVariable("id") int id, @RequestBody PeasantDTO peasantDTO){
        peasantService.addPeasant(id, peasantDTO);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PeasantDTO getPeasant(@PathVariable("id") int id){
        long startTime = System.currentTimeMillis();

        try {
            return peasantService.getPeasant(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            logger.info("GET /peasant/id - getPeasant "+ (System.currentTimeMillis() - startTime) + " millis spent");
        }
        return null;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePeasant(@PathVariable("id") int id){
        peasantService.deletePeasant(id);
    }

    @RequestMapping(value = "/{id}/addLand", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLand(@PathVariable("id") int id, @RequestBody LandDTO landDTO){

        long startTime = System.currentTimeMillis();

        try {
            this.landService.addALand(id, landDTO);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            logger.info("POST /peasant/id/land - addLand " + (System.currentTimeMillis() - startTime) + " millis spent");
        }

    }


}
