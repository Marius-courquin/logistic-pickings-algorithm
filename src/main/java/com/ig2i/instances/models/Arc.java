package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Arc {
    private Location start;
    private Location end;
    private int distance;

    public static Arc of(Location start, Location end, int distance) {
        return new Arc(start, end, distance);
    }
}
