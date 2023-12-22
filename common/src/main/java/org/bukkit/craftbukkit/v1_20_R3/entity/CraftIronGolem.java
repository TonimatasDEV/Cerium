package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.animal.EntityIronGolem;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.entity.IronGolem;

public class CraftIronGolem extends CraftGolem implements IronGolem {
    public CraftIronGolem(CraftServer server, EntityIronGolem entity) {
        super(server, entity);
    }

    @Override
    public EntityIronGolem getHandle() {
        return (EntityIronGolem) entity;
    }

    @Override
    public String toString() {
        return "CraftIronGolem";
    }

    @Override
    public boolean isPlayerCreated() {
        return getHandle().isPlayerCreated();
    }

    @Override
    public void setPlayerCreated(boolean playerCreated) {
        getHandle().setPlayerCreated(playerCreated);
    }
}
