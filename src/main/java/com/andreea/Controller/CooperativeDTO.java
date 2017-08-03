package com.andreea.Controller;

import com.andreea.Repository.Cooperative;
import com.andreea.Repository.Land;
import com.andreea.Repository.Peasant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana Bucurica on 8/2/2017.
 */
public class CooperativeDTO implements Serializable {
    private int id;
    private String name;
    private List<PeasantDTO> peasants = new ArrayList<>();

    public CooperativeDTO () {

    }

    public CooperativeDTO(int id, String name) {
        this.id=id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PeasantDTO> getPeasants() {
        return peasants;
    }

    public void setPeasants(List<PeasantDTO> peasants) {
        this.peasants = peasants;
    }



    public Cooperative dtoToEntity(){
        Cooperative cooperative = new Cooperative(this.name);
        List<Peasant> peasants = new ArrayList<>();
        for (PeasantDTO peasantDTO : this.getPeasants()) {
            Peasant p = peasantDTO.dtoToEntity();
            peasants.add(p);
        }
        cooperative.setPeasants(peasants);
        return cooperative;
    }


}
