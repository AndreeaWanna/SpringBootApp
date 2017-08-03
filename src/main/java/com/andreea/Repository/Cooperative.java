package com.andreea.Repository;

import com.andreea.Controller.CooperativeDTO;
import com.andreea.Controller.LandDTO;
import com.andreea.Controller.PeasantDTO;

import javax.persistence.*;
import javax.sound.sampled.TargetDataLine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana Bucurica on 8/2/2017.
 */
@Entity
@Table(name = "cooperative")
public class Cooperative implements Serializable {

    @Column(name = "id_cooperative")

    private int id;
    @Column
    private String name;

    @OneToMany(targetEntity = Peasant.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cooperative")
    private List<Peasant> peasants;

    public Cooperative(String name) {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public List<Peasant> getPeasants() {
        return peasants;
    }

    public void setPeasants(List<Peasant> peasants) {
        this.peasants = peasants;
    }


     public CooperativeDTO entityToDto() {
       CooperativeDTO cooperativeDTO = new CooperativeDTO(this.id, this.name);
       List<PeasantDTO> peasantDTO = null;
       if ((this.getPeasants()!=null)) {
           peasantDTO = new ArrayList<PeasantDTO>();
           for (Peasant peasant: this.getPeasants()){
               peasantDTO.add(peasant.entityToDto());
           }
       }
       cooperativeDTO.setPeasants(peasantDTO);
       return cooperativeDTO;
   }

    public void addPeasant (Peasant peasant) {
        this.peasants.add(peasant);
    }
}
