package com.ig2i.algorithms.models;

import lombok.Data;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import com.ig2i.instances.models.Article;

@Data
public class GeographicZone {
    private final int longitude;
    private final int latitude;
    private List<Article> articles;

    public GeographicZone(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.articles = new ArrayList<>();
    }

    public void addArticle(Article article) {
        if (article != null) {
            this.articles.add(article);
            this.articles.sort(Comparator.comparing((Article a) -> a.getProduct().getLocation().getLongitude())
                                         .thenComparing(a -> a.getProduct().getLocation().getLatitude()));
        } else {
            throw new IllegalArgumentException("Article cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nZone : [Longitude : " + longitude + " -- Latitude : " + latitude +"]\n")
          .append("Articles : [");
        for(int i = 0; i < articles.size(); i++) {
            sb.append(articles.get(i).toString());
            if (i < articles.size() - 1) {
                sb.append(", \n");
            }
        }
        sb.append("\n] end of articles for a zone \n");

        return sb.toString();
    }
}
