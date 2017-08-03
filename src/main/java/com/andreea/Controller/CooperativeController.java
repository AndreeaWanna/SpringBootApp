package com.andreea.Controller;

import com.andreea.Service.CooperativeService;
import com.andreea.Service.PeasantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oana Bucurica on 8/2/2017.
 */

@RestController
@RequestMapping("/cooperative")
public class CooperativeController {
    @Autowired
    private PeasantService peasantService;
    @Autowired
    private CooperativeService cooperativeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addcooperative(@RequestBody CooperativeDTO cooperativeDTO){
        cooperativeService.addCooperative(cooperativeDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CooperativeDTO getCooperative(@PathVariable("id") int id){
        long startTime = System.currentTimeMillis();

        try {
            return cooperativeService.getCooperative(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //logger.info("GET /cooperative/id - getCooperative "+ (System.currentTimeMillis() - startTime) + " millis spent");
        }
        return null;
    }


}
