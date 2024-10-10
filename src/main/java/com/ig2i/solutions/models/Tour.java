package com.ig2i.solutions.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Tour {
    private List<Parcel> parcels;

    public Tour(){
        this.parcels = new ArrayList<>();
    }

    public static Tour of(List<Parcel> parcel) {
        return new Tour(parcel);
    }

    public int getParcelCount() {
        return this.parcels.size();
    }

    public void addParcel(Parcel parcel) {
        if (parcel != null) {
            this.parcels.add(parcel);
        } else {
            throw new IllegalArgumentException("Parcel cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTour{");
        sb.append("parcels=[");

        for (Parcel parcel : parcels) {
            sb.append(parcel.toString()).append(", ");
        }

        if (!parcels.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        sb.append("}");

        return sb.toString();
    }
}
