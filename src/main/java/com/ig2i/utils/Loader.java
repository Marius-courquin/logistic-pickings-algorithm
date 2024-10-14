package com.ig2i.utils;

public class Loader {

    private final String action;
    private final int maxIterations;
    private int currentIteration = 0;
    private int actualRange = 0;

    private static final int MAX_RANGE = 20;
    private static final char LOADING_CHAR = '█';
    private static final char EMPTY_CHAR = '░';

    public Loader(String action, int maxIterations) {
        this.action = action;
        this.maxIterations = maxIterations;
        System.out.println("Starting " + action + "...");
    }

    public void update() {
        currentIteration++;
        int newRange = (int) Math.floor((double) currentIteration / maxIterations * MAX_RANGE);

        if (newRange > actualRange) {
            actualRange = newRange;

            double percentage = (double) currentIteration / maxIterations * 100;

            System.out.print("\r");
            System.out.printf("%.2f%% [", percentage);
            for (int i = 0; i < actualRange; i++) {
                System.out.print(LOADING_CHAR);
            }
            for (int i = actualRange; i < MAX_RANGE; i++) {
                System.out.print(EMPTY_CHAR);
            }

            System.out.print("]");

            if (newRange == MAX_RANGE) {
                System.out.println();
                System.out.println(action + " finished successfully! \n");
            }
        }
    }
}
