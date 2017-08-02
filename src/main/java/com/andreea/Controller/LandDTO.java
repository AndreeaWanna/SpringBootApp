
package com.andreea.Controller;
import com.andreea.Repository.Land;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oana Bucurica on 7/26/2017.
 */

public class LandDTO implements Serializable{

    private int id;

    private int width;

    private int length;

    public LandDTO(int id, int width, int length) {
        this.id = id;
        this.width = width;
        this.length = length;
    }

    public LandDTO(){

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

    public Land dtoToEntity(){
        Land land =  new Land(this.id, this.width, this.length);
        return land;
    }



}
