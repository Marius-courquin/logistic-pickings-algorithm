package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Article {
    private final int quantity;
    private final Product product;
    private int orderId;

    public static Article of(int quantity, Product product) {
        return new Article(quantity, product);
    }

    public static Article of(int quantity, Product product, int orderId) {
        return new Article(quantity, product, orderId);
    }
}
