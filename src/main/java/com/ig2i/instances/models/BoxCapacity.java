package com.ig2i.instances.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoxCapacity {
    private int weightMax;
    private int volumeMax;
    private boolean isMixedOrdersAllowed;

    public static BoxCapacity of(int weight, int volume, boolean isMixedOrdersAllowed) {
        return new BoxCapacity(weight, volume, isMixedOrdersAllowed);
    }
}
