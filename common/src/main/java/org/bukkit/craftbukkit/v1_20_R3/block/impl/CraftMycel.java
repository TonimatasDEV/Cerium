/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_20_R3.block.impl;

public final class CraftMycel extends org.bukkit.craftbukkit.v1_20_R3.block.data.CraftBlockData implements org.bukkit.block.data.Snowable {

    public CraftMycel() {
        super();
    }

    public CraftMycel(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_20_R3.block.data.CraftSnowable

    private static final net.minecraft.world.level.block.state.properties.BlockStateBoolean SNOWY = getBoolean(net.minecraft.world.level.block.BlockMycel.class, "snowy");

    @Override
    public boolean isSnowy() {
        return get(SNOWY);
    }

    @Override
    public void setSnowy(boolean snowy) {
        set(SNOWY, snowy);
    }
}
