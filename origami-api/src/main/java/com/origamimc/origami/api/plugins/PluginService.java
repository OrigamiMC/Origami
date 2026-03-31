package com.origamimc.origami.api.plugins;

import com.origamimc.origami.api.Origami;

import java.util.List;
import java.util.Optional;

public interface PluginService {

    static PluginService get() {
        return Origami.get().getPluginService();
    }

    Optional<OrigamiPlugin> getPlugin(String name);

    List<OrigamiPlugin> getPlugins();

    default PluginState getPluginState(String name) {
        return getPlugin(name)
                .map(OrigamiPlugin::getState)
                .orElse(PluginState.NOT_EXISTING);
    }

}
