package com.ig2i.instances;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InstanceFileDelimiter {
    NB_LOCATIONS("//NbLocations"),
    NB_PRODUCTS("//NbProducts"),
    NB_BOXES_TROLLEY("//K: NbBoxesTrolley"),
    NB_DIMENSIONS_CAPACITY("//NbDimensionsCapacity"),
    BOX_CAPACITY("//B: CapaBox"),
    MIXED_ORDERS("//A box can accept mixed orders(0: no, 1: yes)"),
    PRODUCTS("//Idx Location Dim1 Dim2 ..."),
    NB_ORDERS("//NbOrders"),
    ORDERS("//Idx M NbProdInOrder ProdIdx1 Qty1 ProdIdx2 Qty2 ..."),
    NB_VERTICES_INTERSECTIONS("//NbVerticesIntersections"),
    DEPARTING_DEPOT("//DepartingDepot"),
    ARRIVAL_DEPOT("//ArrivalDepot"),
    ARCS("//Start End Distance"),
    SHORTEST_PATH("//LocStart LocEnd ShortestPath"),
    LOCATIONS("//Loc x y");

    private final String delimiter;
}
