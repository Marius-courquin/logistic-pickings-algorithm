package com.ig2i.instances;

import com.ig2i.instances.models.Instance;
import com.ig2i.utils.Loader;
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

        var loader = new Loader("reading instances", instanceFiles.length);

        var instances = Arrays.stream(instanceFiles).map( instanceFile -> {
            loader.update();
            return getInstance(instanceFile);
        }).toList();

        return instances;
    }

    public Instance getInstance(InstanceFile instanceFile) {
        return safeReadInstance(instanceFile);
    }

    @SneakyThrows
    private Instance safeReadInstance(InstanceFile instanceFile) {
        return instanceReader.readInstance(instanceFile);
    }
}
