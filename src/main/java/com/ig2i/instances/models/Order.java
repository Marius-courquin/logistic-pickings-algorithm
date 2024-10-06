package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Order {
    private final int id;
    private final int numberMaxOfBoxes;
    private final int numberOfProducts;
    private List<Article> articles = new ArrayList<>();

    public static Order of(int id, int numberMaxOfBoxes, int numberOfProducts) {
        return new Order(id, numberMaxOfBoxes, numberOfProducts);
    }

    public void addArticle (Article product) {
        articles.add(product);
    }
}
