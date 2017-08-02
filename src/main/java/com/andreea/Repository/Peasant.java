package com.andreea.Repository;

import com.andreea.Controller.LandDTO;
import com.andreea.Controller.PeasantDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oana Bucurica on 7/26/2017.
 */

@Entity
@Table(name = "peasant")
public class Peasant implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_peasant")
    private int id;

    @Column
    private String name;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_peasant")
    private List<Land> lands;

    public Peasant () {

    }

    public Peasant( String name, String dateOfBirth, Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;

        this.lands = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Land> getLands() {
        return lands;
    }

    public void setLands(List<Land> lands) {
        this.lands = lands;
    }

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public String toString() {
        return "Peasant{" + "name='" + name + '\'' + ", dateOfBirth='" + dateOfBirth + '\'' + ", gender=" + gender + '}';
    }

    public PeasantDTO entityToDto(){
        PeasantDTO peasantDTO = new PeasantDTO(this.id, this.name,this.dateOfBirth, this.gender);
        List<LandDTO> landsDTO = null;
        if (this.getLands()!=null){
            landsDTO = new ArrayList<LandDTO>();
            for(Land land: this.getLands()){
                landsDTO.add(land.entityToDto());
            }
        }

        peasantDTO.setLands(landsDTO);
        return peasantDTO;
    }

    public void addLand(Land land) {
        this.lands.add(land);
    }
}
