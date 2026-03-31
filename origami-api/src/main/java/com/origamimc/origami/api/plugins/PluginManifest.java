package com.origamimc.origami.api.plugins;

public record PluginManifest(
        String name,
        String version,
        String pluginClass
) {

}
