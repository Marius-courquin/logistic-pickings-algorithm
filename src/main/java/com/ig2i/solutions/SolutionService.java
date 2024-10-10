package com.ig2i.solutions;

import com.ig2i.solutions.models.Solution;

import java.io.IOException;
import java.util.List;

public class SolutionService {

    private final SolutionWriter solutionWriter;

    public SolutionService() {
        this.solutionWriter =  new SolutionWriter();
    }

    public void writeAllSolutions(List<Solution> solutions) throws IOException {
        for (Solution solution : solutions) {
            writeSolution(solution);
        }
    }

    public void writeSolution(Solution instanceSolution) throws IOException {
        solutionWriter.writeSolution(instanceSolution);
    }


}
