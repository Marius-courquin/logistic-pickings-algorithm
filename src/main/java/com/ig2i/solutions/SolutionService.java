package com.ig2i.solutions;

import com.ig2i.solutions.models.Solution;

import java.io.IOException;

public class SolutionService {

    private final SolutionWriter solutionReader;

    public SolutionService() {
        this.solutionReader =  new SolutionWriter();
    }

    public void writeSolution(Solution instanceSolution) throws IOException {
        solutionReader.writeSolution(instanceSolution);
    }
}
