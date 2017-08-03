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

    @RequestMapping(value = "/{id}",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addcooperative(@PathVariable("id") int id, @RequestBody CooperativeDTO cooperativeDTO){
        cooperativeService.addCooperative(id, cooperativeDTO);
    }



}
