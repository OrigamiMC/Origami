package com.origamimc.origami.api.server;

import com.origamimc.origami.api.Origami;
import com.origamimc.origami.api.player.OrigamiPlayer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrigamiServer {

    static OrigamiServer get() {
        return Origami.get().getServer();
    }

    long getStartupTime();

    Optional<OrigamiPlayer> getPlayerByName(String username);

    Optional<OrigamiPlayer> getPlayerByUUID(UUID uuid);

    List<OrigamiPlayer> getOnlinePlayers();

}
