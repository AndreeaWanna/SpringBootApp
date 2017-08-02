package com.andreea.Repository;

import javax.persistence.*;
import javax.sound.sampled.TargetDataLine;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Oana Bucurica on 8/2/2017.
 */
@Entity
@Table(name = "cooperative")
public class Cooperative implements Serializable {
    @Id
    @Column(name = "id_cooperative")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column
    private String name;

    @OneToMany(targetEntity = Peasant.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_cooperative")
    private List<Peasant> peasants;

    public Cooperative() {

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
}
