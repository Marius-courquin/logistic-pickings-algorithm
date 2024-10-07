package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Zone {
    private List<Article> articles;

    public Zone (){
        this.articles = null;
    }

    public static Zone of(List<Article> articles) {
        return new Zone(articles);
    }

    public void addArticle(Article article) {
        this.articles.add(article);
    }
}