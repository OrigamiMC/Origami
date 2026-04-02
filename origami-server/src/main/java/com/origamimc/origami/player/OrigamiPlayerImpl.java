package com.origamimc.origami.player;

import com.origamimc.origami.api.player.OrigamiPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;

public class OrigamiPlayerImpl implements OrigamiPlayer {

    private final ServerPlayer handle;

    public OrigamiPlayerImpl(ServerPlayer serverPlayer) {
        this.handle = serverPlayer;
    }

    @Override
    public String getUsername() {
        return handle.nameAndId().name();
    }

    @Override
    public UUID getUUID() {
        return handle.nameAndId().id();
    }

    @Override
    public int getEntityID() {
        return handle.getId();
    }

    @Override
    public void sendMessage(String message) {
        handle.sendSystemMessage(Component.literal(message));
    }
}
