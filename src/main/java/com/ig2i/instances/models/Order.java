package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private int numberMaxOfBoxes;
    private int numberOfProducts;
    private List<Article> articles;

    public static Order of(int id, int numberMaxOfBoxes, int numberOfProducts, List<Article> articles) {
        return new Order(id, numberMaxOfBoxes, numberOfProducts, articles);
    }
}
