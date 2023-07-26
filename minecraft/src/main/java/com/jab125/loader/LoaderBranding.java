package com.jab125.loader;

import net.minecraft.SharedConstants;

public class LoaderBranding {
    public static final String[] LINES = {"Example Modloader 1.0-SNAPSHOT", "Tweak Loader " + getTweakLoaderVersion(), "Minecraft " + SharedConstants.getGameVersion().getName()};

    private static String getTweakLoaderVersion() {
        return null;
    }

    public static String getBranding(String name) {
        if (name.equals("vanilla")) return "example-modloader";
        return "example-modloader:" + name;
    }
}
