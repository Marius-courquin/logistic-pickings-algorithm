package com.ig2i.algorithms;


import com.ig2i.algorithms.models.Algorithm;
import com.ig2i.instances.models.Instance;
import com.ig2i.solutions.models.Solution;
import lombok.SneakyThrows;

import java.util.List;

public class AlgorithmService {

    private final Algorithm algorithm;

    public AlgorithmService(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public List<Solution> getAllSolutions(List<Instance> instances) {

        var solutions = instances.stream().map(this::safeAlgorithm).toList();

        return solutions;
    }

    public Solution getSolution(Instance instance) {
        return safeAlgorithm(instance);
    }

    @SneakyThrows
    private Solution safeAlgorithm(Instance instance) {
        return algorithm.algorithm(instance);
    }
}
