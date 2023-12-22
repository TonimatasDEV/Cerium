package org.bukkit.craftbukkit.v1_20_R3.block;

import net.minecraft.world.level.block.entity.BlockEntityComparator;
import org.bukkit.World;
import org.bukkit.block.Comparator;

public class CraftComparator extends CraftBlockEntityState<BlockEntityComparator> implements Comparator {

    public CraftComparator(World world, BlockEntityComparator tileEntity) {
        super(world, tileEntity);
    }

    protected CraftComparator(CraftComparator state) {
        super(state);
    }

    @Override
    public CraftComparator copy() {
        return new CraftComparator(this);
    }
}
