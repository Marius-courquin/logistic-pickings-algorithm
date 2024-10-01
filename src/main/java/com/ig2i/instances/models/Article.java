package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private int quantity;
    private Product product;

    public static Article of(int quantity, Product product) {
        return new Article(quantity, product);
    }
}
