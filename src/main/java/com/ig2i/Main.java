package com.ig2i;

import com.ig2i.algorithms.AlgorithmService;
import com.ig2i.algorithms.AlgorithmV1;
import com.ig2i.instances.InstanceService;
import com.ig2i.solutions.SolutionService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var currentAlgorithmUsed = new AlgorithmV1(); // Change this line to use another algorithm

        var instanceService = new InstanceService();
        var algorithmService = new AlgorithmService(currentAlgorithmUsed);
        var solutionService = new SolutionService();

        var instances = instanceService.getAllInstances();

        var solutions = algorithmService.getAllSolutions(instances);

        solutionService.writeAllSolutions(solutions);
    }
}