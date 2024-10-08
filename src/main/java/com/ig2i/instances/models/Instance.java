package com.ig2i.instances.models;

import com.ig2i.instances.InstanceFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
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

    private BoxCapacity boxCapacity;

    private List<Order> orders = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<ShortestPath> shortestPaths = new ArrayList<>();
    private List<Arc> arcs = new ArrayList<>();

    private final InstanceFile instanceFile;

    public static Instance of(int numberOfLocations, int numberOfProducts, int numberOfBoxesTrolley,
                              int numberOfDimensionsCapacity, int numberOfOrders, int numberOfBoxesOrder,
                              int numberOfVerticesIntersections, int departingDepot, int arrivingDepot,
                              BoxCapacity boxCapacity, List<Order> orders, List<Location> locations,
                              List<Product> products, List<ShortestPath> shortestPaths, List<Arc> arcs, InstanceFile instanceFile) {
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
                boxCapacity,
                orders,
                locations,
                products,
                shortestPaths,
                arcs,
                instanceFile
        );
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addShortestPath(ShortestPath shortestPath) {
        shortestPaths.add(shortestPath);
    }

    public void addArc(Arc arc) {
        arcs.add(arc);
    }

    public Location getLocationById(int id) {
        return locations.stream().filter(location -> location.getId() == id).findFirst().orElse(null);
    }

    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    public Order getOrderById(int id) {
        return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
    }
}
