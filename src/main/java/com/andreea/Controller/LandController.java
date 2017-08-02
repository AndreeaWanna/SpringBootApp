package com.andreea.Controller;

import com.andreea.Service.LandService;
import com.andreea.Service.PeasantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oana Bucurica on 7/31/2017.
 */
@RestController
@RequestMapping("/land")
public class LandController {
    @Autowired
    private PeasantService peasantService;
    @Autowired
    private LandService landService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addLand(@PathVariable("id") int id, @RequestBody LandDTO landDTO) {

        landService.addALand(id,landDTO);

    }

}
