package com.noname.jobhub.h2storage.position;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class PersistentPosition implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String location;

    public PersistentPosition() {
    }

    public PersistentPosition(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
