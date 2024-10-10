package com.ig2i.solutions.models;

import com.ig2i.instances.models.Article;
import com.ig2i.instances.models.BoxCapacity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Parcel {
    private int orderId;
    private BoxCapacity boxCapacity;
    private List<Article> articles;

    public Parcel(int orderId, BoxCapacity boxCapacity) {
        this.orderId = orderId;
        this.boxCapacity = boxCapacity;
        this.articles = new ArrayList<>();
    }

    public static Parcel of(int orderId, BoxCapacity boxCapacity, List<Article> articles) {
        return new Parcel(orderId, boxCapacity, articles);
    }

    public int getCurrentWeight() {
        return articles.stream().mapToInt(article -> article.getQuantity() * article.getProduct().getWeight()).sum();
    }

    public int getCurrentVolume() {
        return articles.stream().mapToInt(article -> article.getQuantity() * article.getProduct().getVolume()).sum();
    }

    public boolean addArticle(Article article) {
        if (article == null) {
            return false;
        }

        int currentWeight = this.getCurrentWeight();
        int currentVolume = this.getCurrentVolume();

        boolean hasEnoughWeightCapacity = (currentWeight + article.getWeight()) <= this.boxCapacity.getWeightMax();
        boolean hasEnoughVolumeCapacity = (currentVolume + article.getVolume()) <= this.boxCapacity.getVolumeMax();

        if (hasEnoughWeightCapacity && hasEnoughVolumeCapacity) {
            this.articles.add(article);
            return true;
        }

        return false;
    }

    public int getArticleCount() {
        return articles.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nParcel{");
        sb.append("orderId=").append(orderId);
        sb.append(", boxCapacity=").append(boxCapacity);
        sb.append(", articles=[");

        for (Article article : articles) {
            sb.append(article.toString()).append(", ");
        }

        if (!articles.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        sb.append("}");

        return sb.toString();
    }
}
