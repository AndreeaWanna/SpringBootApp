package com.andreea.Controller;

import com.andreea.Repository.Land;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import com.andreea.Repository.Peasant;
import com.andreea.Repository.Gender;

/**
 * Created by Oana Bucurica on 7/26/2017.
 */


public class PeasantDTO implements Serializable {
    //adnotare de Id din persistance, nu din springframework annotations


    private int id;

    private String name;

    private String dateOfBirth;

    private Gender gender;

    private List<LandDTO> lands = new ArrayList<>();

    public PeasantDTO () {

    }
    public PeasantDTO(int id, String name, String dateOfBirth, Gender gender) {
        this.id=id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<LandDTO> getLands() {
        return lands;
    }

    public void setLands(List<LandDTO> lands) {
        this.lands = lands;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLand(LandDTO land) {
        this.lands.add(land);
    }




    @Override
    public String toString() {
        return "Peasant{" + "name='" + name + '\'' + ", dateOfBirth='" + dateOfBirth + '\'' + ", gender=" + gender + '}';
    }
    public Peasant dtoToEntity(){
       Peasant peasant = new Peasant(this.name, this.dateOfBirth, this.gender);
        List<Land> lands = new ArrayList<>();
       for (LandDTO landDTO : this.getLands()) {
           Land l = landDTO.dtoToEntity();
           lands.add(l);
       }
       peasant.setLands(lands);
       return peasant;
    }


}

