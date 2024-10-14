package com.ig2i.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.ig2i.algorithms.models.Algorithm;
import com.ig2i.instances.models.Article;
import com.ig2i.instances.models.Instance;
import com.ig2i.algorithms.models.GeographicZone;
import com.ig2i.instances.models.Order;
import com.ig2i.solutions.models.Parcel;
import com.ig2i.solutions.models.Solution;
import com.ig2i.solutions.models.Tour;

public class AlgorithmBaptisteV0 implements Algorithm {
    @Override
    public Solution algorithm(Instance instance) {
        var solution = new Solution(instance.getInstanceFile());
        var gZones = new ArrayList<GeographicZone>();

        processOrders(instance, gZones);
        sortZonesByCoordonates(gZones);        

        //for(ShortestPath spath : instance.getShortestPaths()) {
        //    System.out.println(spath.toString());
        //}

        createSolution(solution, instance, gZones);

        //System.out.println(solution.toString());

        return solution;
    }

        private void processOrders(Instance instance, List<GeographicZone> gZones) {
        for (Order order : instance.getOrders()) {
            processArticlesForOrder(gZones, order);
        }
    }

    private void processArticlesForOrder(List<GeographicZone> gZones, Order order) {
        for (Article article : order.getArticles()) {
            setArticleInZone(gZones, article);
        }
    }

    private void setArticleInZone(List<GeographicZone> gZones, Article article){
        boolean existingZone = false;

        for (GeographicZone gZone : gZones) {
            if (article.getProduct().getLocation().getLongitude() == gZone.getLongitude() &&
                article.getProduct().getLocation().getLatitude() == gZone.getLatitude()) {
                gZone.addArticle(article);
                existingZone = true;
                break;
            }
        }

        if(!existingZone){
            GeographicZone gZone = new GeographicZone(article.getProduct().getLocation().getLongitude(), article.getProduct().getLocation().getLatitude());
            gZone.addArticle(article);
            gZones.add(gZone);
        }
    }

    private void sortZonesByCoordonates(List<GeographicZone> gZones) {
        gZones.sort(Comparator.comparing(GeographicZone::getLongitude)
                                .thenComparing(GeographicZone::getLatitude));
    }

    private void createSolution(Solution solution,Instance instance, List<GeographicZone> gZones){
        for(GeographicZone gZone : gZones) {
            Tour tour = new Tour();
            for(Article art : gZone.getArticles()) {
                Optional<Parcel> matchingParcel = tour.getParcels().stream()
                    .filter(parcel -> parcel.getOrderId() == art.getOrderId())
                    .findFirst();

                if(matchingParcel.isPresent()) {
                    if(!matchingParcel.get().addArticle(art)) {
                        Parcel newParcel = new Parcel(art.getOrderId(), instance.getBoxCapacity());
                        newParcel.addArticle(art);
                        tour.addParcel(newParcel);
                    }
                } else {
                    Parcel newParcel = new Parcel(art.getOrderId(), instance.getBoxCapacity());
                    newParcel.addArticle(art);
                    tour.addParcel(newParcel);
                }
            }

            //System.out.println(tour.getParcelCount() + " box in that tour");
            //for(Parcel parcel : tour.getParcels()) {
            //    System.out.println("Order number : " + parcel.getOrderId());
            //    System.out.println("Volume : " + parcel.getCurrentVolume() + " Volume max : " + instance.getBoxCapacity().getVolumeMax());
            //    System.out.println("Weight : " + parcel.getCurrentWeight() + " Weight max : " + instance.getBoxCapacity().getWeightMax());
            //    for(Article article : parcel.getArticles()) {
            //        System.out.println("Longitude : " + article.getProduct().getLocation().getLongitude() + " -- Latitude : " + 
            //                                            article.getProduct().getLocation().getLatitude());
            //    }
            //}

            solution.addTour(tour);
        }

        int depth = 4;
        for(Tour tour : solution.getTour()) {
            System.out.println(tour.toString());

        }
        
                
        
        
        

        //for(Zone zone: zones){
        //    for(Article article: zone.getArticles()) {
        //        addArticleToSolution(solution, instance, article);
        //    }
        //}
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
