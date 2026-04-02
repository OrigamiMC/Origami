package com.origamimc.origami.api.player;

import java.util.UUID;

public interface OrigamiPlayer {

    String getUsername();

    UUID getUUID();

    int getEntityID();

    void sendMessage(String message);

    void sendActionBar(String text);

}
