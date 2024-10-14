package com.ig2i.algorithms;

import com.ig2i.algorithms.models.Algorithm;
import com.ig2i.instances.models.Article;
import com.ig2i.instances.models.Instance;
import com.ig2i.instances.models.Order;
import com.ig2i.algorithms.models.Zone;
import com.ig2i.solutions.models.Parcel;
import com.ig2i.solutions.models.Solution;
import com.ig2i.solutions.models.Tour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlgorithmV1 implements Algorithm {

    @Override
    public Solution algorithm(Instance instance) {
        var solution = new Solution(instance.getInstanceFile());
        var zones = new ArrayList<Zone>();

        processOrders(instance, zones);

        sortZonesByName(zones);

        createSolution(solution, instance, zones);

        return solution;
    }

    private void processOrders(Instance instance, List<Zone> zones) {
        for (Order order : instance.getOrders()) {
            processArticlesForOrder(instance, zones, order);
        }
    }

    private void processArticlesForOrder(Instance instance, List<Zone> zones, Order order) {
        for (Article article : order.getArticles()) {
            setArticleInZone(instance, zones, article);
        }
    }

    private void setArticleInZone(Instance instance, List<Zone> zones, Article article){
        boolean existingZone = false;

        for (Zone zone : zones) {
            if (article.getNameOfProductLocation().substring(1, 6).equals(zone.getName())) {
                addListOfArticleInZone(instance, zone, article);
                existingZone = true;
                break;
            }
        }

        if(!existingZone){
            Zone zone = new Zone(article.getNameOfProductLocation().substring(1, 6));
            addListOfArticleInZone(instance, zone, article);
            zones.add(zone);
        }
    }

    private void addListOfArticleInZone(Instance instance, Zone zone, Article article){
        List<Article> articles = splitArticleIfTooHeavy(instance, article);

        for(Article art: articles){
            zone.addArticle(art);
        }
    }

    private List<Article> splitArticleIfTooHeavy(Instance instance, Article article){
        List<Article> articles = new ArrayList<>();
        int remainingQuantity = article.getQuantity();

        int nbArticlePossibleInOneBoxByWeight = instance.getBoxCapacity().getWeightMax() / article.getProduct().getWeight();
        int nbArticlePossibleInOneBoxByVolume = instance.getBoxCapacity().getVolumeMax() / article.getProduct().getVolume();

        int quantityToAdd = Math.min(nbArticlePossibleInOneBoxByWeight, nbArticlePossibleInOneBoxByVolume);

        while (remainingQuantity > 0) {
            int currentQuantity = Math.min(quantityToAdd, remainingQuantity);
            Article newArticle = Article.of(currentQuantity, article.getProduct(), article.getOrderId());
            articles.add(newArticle);

            remainingQuantity -= currentQuantity;
        }

        return articles;
    }

    private void sortZonesByName(List<Zone> zones) {
        zones.sort(Comparator.comparing(Zone::getName));
    }

    private void createSolution(Solution solution,Instance instance, List<Zone> zones){
        Tour tour= new Tour();
        solution.addTour(tour);

        for(Zone zone: zones){
            for(Article article: zone.getArticles()) {
                addArticleToSolution(solution, instance, article);
            }
        }
    }

    private void addArticleToSolution(Solution solution, Instance instance, Article article){
        for(Tour tour: solution.getTour()){
            if (findAndAddArticleToParcel(tour, article)) {
                return;
            }

            if (tour.getParcelCount() < instance.getNumberOfBoxesTrolley()) {
                createNewParcelForTour(instance, tour, article);
                return;
            }
        }

        createNewTourWithParcel(solution, instance, article);
    }

    private boolean findAndAddArticleToParcel(Tour tour, Article article) {
        for (Parcel parcel : tour.getParcels()) {
            if (parcel.getOrderId() == article.getOrderId() && parcel.addArticle(article)) {
                return true;
            }
        }
        return false;
    }

    private void createNewParcelForTour(Instance instance, Tour tour, Article article) {
        Parcel parcel = createParcelAndAddArticle(instance, article);
        tour.addParcel(parcel);
    }

    private Parcel createParcelAndAddArticle(Instance instance, Article article) {
        Parcel parcel = new Parcel(article.getOrderId(), instance.getBoxCapacity());
        parcel.addArticle(article);
        return parcel;
    }

    private void createNewTourWithParcel(Solution solution, Instance instance, Article article) {
        Tour tour = new Tour();
        createNewParcelForTour(instance, tour, article);
        solution.addTour(tour);
    }
}
