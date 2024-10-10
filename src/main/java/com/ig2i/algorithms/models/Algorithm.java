package com.ig2i.algorithms.models;

import com.ig2i.instances.models.Instance;
import com.ig2i.solutions.models.Solution;

public interface Algorithm {
    Solution algorithm(Instance instance);
}
