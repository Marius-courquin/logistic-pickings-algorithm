package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class InstanceSolution {
    private List<Tour> tour;

    public InstanceSolution (){
        this.tour = new ArrayList<>();
    }
}
