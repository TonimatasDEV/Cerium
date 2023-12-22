package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.monster.EntitySkeletonStray;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Stray;

public class CraftStray extends CraftAbstractSkeleton implements Stray {

    public CraftStray(CraftServer server, EntitySkeletonStray entity) {
        super(server, entity);
    }

    @Override
    public String toString() {
        return "CraftStray";
    }

    @Override
    public SkeletonType getSkeletonType() {
        return SkeletonType.STRAY;
    }
}
