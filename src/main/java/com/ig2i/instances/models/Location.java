package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private int id;
    private int longitude;
    private int latitude;
    private String name;

    public static Location of(int id, int longitude, int latitude, String name) {
        return new Location(id, longitude, latitude, name);
    }

    @Override
    public String toString() {
        return "Location: " +
                "ID: " + id +
                ", Name: '" + name + '\'' +
                ", Longitude: " + longitude +
                ", Latitude: " + latitude;
    }
}
