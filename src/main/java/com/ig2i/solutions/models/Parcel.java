package com.ig2i.solutions.models;

import com.ig2i.instances.models.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Parcel {
    private int orderId;
    private List<Article> articles;

    public static Parcel of(int orderId, List<Article> articles) {
        return new Parcel(orderId, articles);
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public int getArticleCount() {
        return articles.size();
    }
}
