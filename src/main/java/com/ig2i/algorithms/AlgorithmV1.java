package com.ig2i.algorithms;

import com.ig2i.algorithms.models.BaseAlgorithm;
import com.ig2i.instances.models.Article;
import com.ig2i.instances.models.Instance;
import com.ig2i.instances.models.Order;
import com.ig2i.instances.models.Zone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlgorithmV1 extends BaseAlgorithm {

    public AlgorithmV1(Instance instance) {
        super(instance);
    }

    @Override
    public void algorithm() {
        List<Zone> zoneNord = new ArrayList<>();
        List<Zone> zoneSud = new ArrayList<>();

        for (Order order : this.instance.getOrders()) {
            for (Article article : order.getArticles()) {
                if (article.getNameOfProductLocation().charAt(1) == 'a') {
                    setArticleInZone(zoneNord, article);
                }else{
                    setArticleInZone(zoneSud, article);
                }
            }
        }

        zoneNord.sort(Comparator.comparing(Zone::getName));
        zoneSud.sort(Comparator.comparing(Zone::getName));

        System.out.println(zoneNord);
    }

    void setArticleInZone(List<Zone> zones, Article article){
        boolean existingZone = false;

        for (Zone zone : zones) {
            if (article.getNameOfProductLocation().substring(1, 6).equals(zone.getName())) {
                zone.addArticle(article);
                existingZone = true;
                break;
            }
        }

        if(!existingZone){
            Zone zone = new Zone(article.getNameOfProductLocation().substring(1, 6));
            zone.addArticle(article);
            zones.add(zone);
        }
    }
}
