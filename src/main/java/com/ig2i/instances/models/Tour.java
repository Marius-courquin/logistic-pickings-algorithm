package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Tour {
    private List<Parcel> parcel;

    public Tour() {
        this.parcel = new ArrayList<>();
    }
}
