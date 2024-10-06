package com.ig2i.instances;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InstanceFile {
    INSTANCE_01("instance_0116_131933_Z1"),
    INSTANCE_02("instance_0116_131933_Z2"),
    INSTANCE_03("instance_0116_131936_Z1"),
    INSTANCE_04("instance_0116_131936_Z2"),
    INSTANCE_05("instance_0116_131940_Z1"),
    INSTANCE_06("instance_0116_131940_Z2"),
    INSTANCE_07("instance_0116_131942_Z1"),
    INSTANCE_08("instance_0116_131942_Z2"),
    INSTANCE_09("instance_0116_131948_Z1"),
    INSTANCE_10("instance_0116_131948_Z2");

    private final String fileName;

    private static final String PATH = "src/main/resources/instances/";

    public String getPath() {
        return PATH + fileName + ".txt";
    }
}
