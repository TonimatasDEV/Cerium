/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_20_R3.block.impl;

public final class CraftCoralFanAbstract extends org.bukkit.craftbukkit.v1_20_R3.block.data.CraftBlockData implements org.bukkit.block.data.Waterlogged {

    public CraftCoralFanAbstract() {
        super();
    }

    public CraftCoralFanAbstract(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_20_R3.block.data.CraftWaterlogged

    private static final net.minecraft.world.level.block.state.properties.BlockStateBoolean WATERLOGGED = getBoolean(net.minecraft.world.level.block.BlockCoralFanAbstract.class, "waterlogged");

    @Override
    public boolean isWaterlogged() {
        return get(WATERLOGGED);
    }

    @Override
    public void setWaterlogged(boolean waterlogged) {
        set(WATERLOGGED, waterlogged);
    }
}
