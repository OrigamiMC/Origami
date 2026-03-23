package com.origamimc.origami.api;

public class OrigamiInstanceHolder {

    private static Origami instance;

    public static void setInstance(Origami instance) {
        if (OrigamiInstanceHolder.instance != null) {
            throw new IllegalStateException("Origami instance has already been set.");
        }

        OrigamiInstanceHolder.instance = instance;
    }

    public static Origami getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Origami instance has not been set.");
        }

        return instance;
    }

}
