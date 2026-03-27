package com.origamimc.origami.api;

import de.oliver.fancyanalytics.logger.ExtendedFancyLogger;

public interface Origami {

    static Origami get() {
        return OrigamiInstanceHolder.getInstance();
    }

    static ExtendedFancyLogger logger() {
        return get().getLogger();
    }

    ExtendedFancyLogger getLogger();

}
