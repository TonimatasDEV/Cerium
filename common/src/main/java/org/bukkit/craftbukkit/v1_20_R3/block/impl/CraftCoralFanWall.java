/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_20_R3.block.impl;

public final class CraftCoralFanWall extends org.bukkit.craftbukkit.v1_20_R3.block.data.CraftBlockData implements org.bukkit.block.data.type.CoralWallFan, org.bukkit.block.data.Directional, org.bukkit.block.data.Waterlogged {

    public CraftCoralFanWall() {
        super();
    }

    public CraftCoralFanWall(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_20_R3.block.data.CraftDirectional

    private static final net.minecraft.world.level.block.state.properties.BlockStateEnum<?> FACING = getEnum(net.minecraft.world.level.block.BlockCoralFanWall.class, "facing");

    @Override
    public org.bukkit.block.BlockFace getFacing() {
        return get(FACING, org.bukkit.block.BlockFace.class);
    }

    @Override
    public void setFacing(org.bukkit.block.BlockFace facing) {
        set(FACING, facing);
    }

    @Override
    public java.util.Set<org.bukkit.block.BlockFace> getFaces() {
        return getValues(FACING, org.bukkit.block.BlockFace.class);
    }

    // org.bukkit.craftbukkit.v1_20_R3.block.data.CraftWaterlogged

    private static final net.minecraft.world.level.block.state.properties.BlockStateBoolean WATERLOGGED = getBoolean(net.minecraft.world.level.block.BlockCoralFanWall.class, "waterlogged");

    @Override
    public boolean isWaterlogged() {
        return get(WATERLOGGED);
    }

    @Override
    public void setWaterlogged(boolean waterlogged) {
        set(WATERLOGGED, waterlogged);
    }
}
