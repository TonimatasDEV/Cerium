package org.bukkit.craftbukkit.v1_20_R3.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.WorldDimension;

public class CraftDimensionUtil {

    private CraftDimensionUtil() {
    }

    public static ResourceKey<World> getMainDimensionKey(World world) {
        ResourceKey<WorldDimension> typeKey = world.getTypeKey();
        if (typeKey == WorldDimension.OVERWORLD) {
            return World.OVERWORLD;
        } else if (typeKey == WorldDimension.NETHER) {
            return World.NETHER;
        } else if (typeKey == WorldDimension.END) {
            return World.END;
        }

        return world.dimension();
    }
}
