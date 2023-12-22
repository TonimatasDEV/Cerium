package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.animal.EntityCow;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.entity.Cow;

public class CraftCow extends CraftAnimals implements Cow {

    public CraftCow(CraftServer server, EntityCow entity) {
        super(server, entity);
    }

    @Override
    public EntityCow getHandle() {
        return (EntityCow) entity;
    }

    @Override
    public String toString() {
        return "CraftCow";
    }
}
