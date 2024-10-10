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
    private List<Tour> tour;

    public Solution(InstanceFile instanceFile) {
        this.instanceFile = instanceFile;
        this.tour = new ArrayList<>();
    }

    public static Solution of(InstanceFile instanceFile, List<Tour> tour) {
        return new Solution(instanceFile, tour);
    }

    public void addTour(Tour tour) {
        this.tour.add(tour);
    }

    public int getTourCount() {
        return this.tour.size();
    }

    public Tour getTourByIndex(int index) {
        return this.tour.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Solution{");
        sb.append("instanceFile=").append(instanceFile);
        sb.append(", tours=[");

        for (Tour tour : tour) {
            sb.append(tour.toString()).append(", ");
        }

        if (!tour.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        sb.append("}");

        return sb.toString();
    }
}
