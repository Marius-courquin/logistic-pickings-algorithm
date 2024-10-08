package com.ig2i;

import com.ig2i.algorithms.AlgorithmV1;
import com.ig2i.instances.InstanceService;

public class Main {
    public static void main(String[] args) {
        var instanceService = new InstanceService();

        var instances = instanceService.getAllInstances();
        AlgorithmV1 result = new AlgorithmV1(instances.getFirst());
        result.algorithm();
        // TODO use instances with algorithms
    }
}