package com.ig2i.algorithms.models;

import com.ig2i.instances.models.Instance;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseAlgorithm {
    protected Instance instance;

    protected abstract void algorithm();
}
