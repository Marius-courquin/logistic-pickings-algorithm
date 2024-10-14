package com.ig2i.solutions;

import com.ig2i.solutions.models.Solution;
import com.ig2i.utils.Loader;

import java.io.IOException;
import java.util.List;

public class SolutionService {

    private final SolutionWriter solutionWriter;

    public SolutionService() {
        this.solutionWriter =  new SolutionWriter();
    }

    public void writeAllSolutions(List<Solution> solutions) throws IOException {
        var loader = new Loader("writing solutions", solutions.size());

        for (Solution solution : solutions) {
            writeSolution(solution);
            loader.update();
        }
    }

    public void writeSolution(Solution instanceSolution) throws IOException {
        solutionWriter.writeSolution(instanceSolution);
    }


}
