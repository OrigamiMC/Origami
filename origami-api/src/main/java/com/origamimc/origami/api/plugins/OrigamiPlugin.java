package com.origamimc.origami.api.plugins;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public abstract class OrigamiPlugin {

    @NotNull private final PluginManifest manifest;
    @NotNull private PluginState state;

    public OrigamiPlugin(@NonNull PluginManifest manifest) {
        this.state = PluginState.DISABLED;
        this.manifest = manifest;
    }

    public abstract void onLoad();

    public abstract void onEnable();

    public abstract void onDisable();

    @ApiStatus.Internal
    public void load() {
        Preconditions.checkArgument(state == PluginState.DISABLED, "Plugin must be in DISABLED state to be loaded");

        onLoad();
        state = PluginState.LOADED;
    }

    @ApiStatus.Internal
    public void enable() {
        Preconditions.checkArgument(state == PluginState.LOADED, "Plugin must be in LOADED state to be enabled");

        onEnable();
        state = PluginState.ENABLED;
    }

    @ApiStatus.Internal
    public void disable() {
        Preconditions.checkArgument(state == PluginState.ENABLED, "Plugin must be in ENABLED state to be disabled");

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
