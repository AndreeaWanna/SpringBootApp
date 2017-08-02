package com.andreea.Repository;

import com.andreea.Controller.LandDTO;
import com.andreea.Controller.PeasantDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oana Bucurica on 7/26/2017.
 */
@Entity
@Table(name = "land")
public class Land implements Serializable{
    @Id
    @Column(name = "id_land")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private int width;
    @Column
    private int length;

    public Land(){}

    public Land(int id, int width, int length) {
        this.id = id;
        this.width = width;
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public long getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public LandDTO entityToDto(){
        LandDTO landDTO =  new LandDTO(this.id, this.width, this.length);
        return landDTO;
    }


}
