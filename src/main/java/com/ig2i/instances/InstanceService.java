package com.ig2i.instances;

import com.ig2i.instances.models.Instance;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class InstanceService {

    private final InstanceReader instanceReader;

    public InstanceService() {
        this.instanceReader = new InstanceReader();
    }

    public List<Instance> getAllInstances() {
        var instanceFiles = InstanceFile.values();

        var instances = Arrays.stream(instanceFiles).map(this::safeReadInstance).toList();

        return instances;
    }

    @SneakyThrows
    private Instance safeReadInstance(InstanceFile instanceFile) {
        return instanceReader.readInstance(instanceFile);
    }
}
