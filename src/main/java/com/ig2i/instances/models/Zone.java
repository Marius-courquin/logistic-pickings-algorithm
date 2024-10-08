package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Zone {
    private String name;
    private List<Article> articles;

    public Zone (String name){
        this.name = name;
        this.articles = new ArrayList<>();
    }

    public void addArticle(Article article) {
        if (article != null) {
            this.articles.add(article);
            this.articles.sort(Comparator.comparing(a -> a.getProduct().getLocation().getName()));
        } else {
            throw new IllegalArgumentException("Article cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zone: ")
                .append("Name: '").append(name).append('\n')
                .append(", Articles: [");

        for (int i = 0; i < articles.size(); i++) {
            sb.append(articles.get(i).toString());
            if (i < articles.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("]\n");
        return sb.toString();
    }
}