package com.ig2i.solutions.models;

import com.ig2i.instances.InstanceFile;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Solution {
    private InstanceFile instanceFile;
    private List<Tour> tour = new ArrayList<>();

    void addTour(Tour tour) {
        this.tour.add(tour);
    }

    public int getTourCount() {
        return this.tour.size();
    }

    public Tour getTourByIndex(int index) {
        return this.tour.get(index);
    }

    public static Solution of(InstanceFile instanceFile, List<Tour> tour) {
        return new Solution(instanceFile, tour);
    }
}
