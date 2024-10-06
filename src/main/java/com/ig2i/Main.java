package com.ig2i;

import com.ig2i.instances.InstanceService;

public class Main {
    public static void main(String[] args) {
        var instanceService = new InstanceService();

        var instances = instanceService.getAllInstances();

        // TODO use instances with algorithms
    }
}