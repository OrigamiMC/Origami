package com.origamimc.origami.api.plugins;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

public abstract class OrigamiPlugin {

    @NotNull private final PluginManifest manifest;
    @NotNull private PluginState state;

    public OrigamiPlugin(@NotNull PluginManifest manifest) {
        this.state = PluginState.DISABLED;
        this.manifest = manifest;
    }

    public abstract void onLoad();

    public abstract void onEnable();

    public abstract void onDisable();

    @ApiStatus.Internal
    public void load() {
        if (state != PluginState.DISABLED) {
            throw new IllegalStateException("Plugin must be in DISABLED state to be loaded");
        }

        onLoad();
        state = PluginState.LOADED;
    }

    @ApiStatus.Internal
    public void enable() {
        if (state != PluginState.LOADED) {
            throw new IllegalStateException("Plugin must be in LOADED state to be enabled");
        }

        onEnable();
        state = PluginState.ENABLED;
    }

    @ApiStatus.Internal
    public void disable() {
        if (state != PluginState.ENABLED) {
            throw new IllegalStateException("Plugin must be in ENABLED state to be disabled");
        }

        onDisable();
        state = PluginState.DISABLED;
    }

    public @NotNull PluginState getState() {
        return state;
    }

    public @NotNull PluginManifest getManifest() {
        return manifest;
    }
}
