package com.noname.jobhub.businessrules.position;

import javax.validation.constraints.Size;

public class Position {

    @Size(min = 2, max = 50)
    private final String name;
    @Size(max = 50)
    private final String location;
    private Integer id;

    public Position(String name, String location) {
        this(null, name, location);
    }

    public Position(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (this.id != null)
            throw new IllegalAccessError("Overwrite is not allowed");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

}
