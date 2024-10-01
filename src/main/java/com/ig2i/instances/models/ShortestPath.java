package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShortestPath {
    private Location start;
    private Location end;
    private int distance;

    public static ShortestPath of(Location start, Location end, int distance) {
        return new ShortestPath(start, end, distance);
    }
}
