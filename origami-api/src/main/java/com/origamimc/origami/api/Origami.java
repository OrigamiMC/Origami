package com.origamimc.origami.api;

public interface Origami {

    static Origami get() {
        return OrigamiInstanceHolder.getInstance();
    }

}
