package com.origamimc.origami;

import com.origamimc.origami.api.Origami;

public class OrigamiImpl implements Origami {

    private final OrigamiServerImpl server;

    public static OrigamiImpl get() {
        return (OrigamiImpl) Origami.get();
    }

    public OrigamiImpl() {
        this.server = new OrigamiServerImpl();
    }

    public OrigamiServerImpl getServer() {
        return server;
    }
}
