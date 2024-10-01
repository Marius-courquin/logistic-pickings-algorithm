package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Instance {
    private int numberOfLocations;
    private int numberOfProducts;
    private int numberOfBoxesTrolley;
    private int numberOfDimensionsCapacity;
    private int numberOfOrders;
    private int numberOfBoxesOrder;
    private int numberOfVerticesIntersections;
    private int departingDepot;
    private int arrivingDepot;

    private List<Order> orders;
    private List<Location> locations;
    private List<Product> products;
    private List<ShortestPath> shortestPaths;
    private List<Arc> arcs;

    public static Instance of(int numberOfLocations, int numberOfProducts, int numberOfBoxesTrolley,
                              int numberOfDimensionsCapacity, int numberOfOrders, int numberOfBoxesOrder,
                              int numberOfVerticesIntersections, int departingDepot, int arrivingDepot,
                              List<Order> orders, List<Location> locations, List<Product> products,
                              List<ShortestPath> shortestPaths, List<Arc> arcs) {
        return new Instance(
                numberOfLocations,
                numberOfProducts,
                numberOfBoxesTrolley,
                numberOfDimensionsCapacity,
                numberOfOrders,
                numberOfBoxesOrder,
                numberOfVerticesIntersections,
                departingDepot,
                arrivingDepot,
                orders,
                locations,
                products,
                shortestPaths,
                arcs);
    }

}
