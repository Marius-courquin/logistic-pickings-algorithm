package com.ig2i;

import com.ig2i.algorithms.AlgorithmV1;
import com.ig2i.instances.InstanceService;
import com.ig2i.solutions.SolutionService;

public class Main {
    public static void main(String[] args) {
        var instanceService = new InstanceService();
        var solutionService = new SolutionService();

        var instances = instanceService.getAllInstances();
        AlgorithmV1 result = new AlgorithmV1(instances.getFirst());
        result.algorithm();

        // TODO use instances with algorithms
    }
}