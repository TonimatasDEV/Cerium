package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.decoration.EntityHanging;
import org.bukkit.block.BlockFace;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.craftbukkit.v1_20_R3.block.CraftBlock;
import org.bukkit.entity.Hanging;

public class CraftHanging extends CraftEntity implements Hanging {
    public CraftHanging(CraftServer server, EntityHanging entity) {
        super(server, entity);
    }

    @Override
    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

    @Override
    public void setFacingDirection(BlockFace face) {
        setFacingDirection(face, false);
    }

    @Override
    public boolean setFacingDirection(BlockFace face, boolean force) {
        EntityHanging hanging = getHandle();
        Direction dir = hanging.getDirection();
        switch (face) {
            case SOUTH:
                getHandle().setDirection(Direction.SOUTH);
                break;
            case WEST:
                getHandle().setDirection(Direction.WEST);
                break;
            case NORTH:
                getHandle().setDirection(Direction.NORTH);
                break;
            case EAST:
                getHandle().setDirection(Direction.EAST);
                break;
            default:
                throw new IllegalArgumentException(String.format("%s is not a valid facing direction", face));
        }
        if (!force && !getHandle().generation && !hanging.survives()) {
            // Revert since it doesn't fit
            hanging.setDirection(dir);
            return false;
        }
        return true;
    }

    @Override
    public BlockFace getFacing() {
        Direction direction = this.getHandle().getDirection();
        if (direction == null) return BlockFace.SELF;
        return CraftBlock.notchToBlockFace(direction);
    }

    @Override
    public EntityHanging getHandle() {
        return (EntityHanging) entity;
    }

    @Override
    public String toString() {
        return "CraftHanging";
    }
}
