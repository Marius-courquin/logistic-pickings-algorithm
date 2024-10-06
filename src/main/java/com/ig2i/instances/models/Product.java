package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private final int id;
    private final int weight;
    private final int volume;
    private Location location;

    public static Product of(int id, int weight, int volume, Location location) {
        return new Product(id, weight, volume, location);
    }

}
