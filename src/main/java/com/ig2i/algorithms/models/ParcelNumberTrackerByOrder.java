package com.ig2i.algorithms.models;

import lombok.Data;

@Data
public class ParcelNumberTrackerByOrder {
    private int orderId;
    private int currentNumberOfParcels;
    private int numberMaxOfBoxes;

    public ParcelNumberTrackerByOrder(int orderId, int numberMaxOfBoxes) {
        this.orderId = orderId;
        this.currentNumberOfParcels = 0;
        this.numberMaxOfBoxes = numberMaxOfBoxes;
    }

    public void incrementNumberOfParcels() {
        this.currentNumberOfParcels++;
    }

    public boolean canDoAnotherParcel() {
        return this.currentNumberOfParcels < this.numberMaxOfBoxes;
    }
}