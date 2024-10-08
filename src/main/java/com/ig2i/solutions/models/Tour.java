package com.ig2i.solutions.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Tour {
    private List<Parcel> parcel = new ArrayList<>();

    public static Tour of(List<Parcel> parcel) {
        return new Tour(parcel);
    }

    public int getParcelCount() {
        return this.parcel.size();
    }
}
