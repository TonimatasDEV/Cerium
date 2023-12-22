package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.monster.EntityPigZombie;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.entity.PigZombie;

public class CraftPigZombie extends CraftZombie implements PigZombie {

    public CraftPigZombie(CraftServer server, EntityPigZombie entity) {
        super(server, entity);
    }

    @Override
    public int getAnger() {
        return getHandle().getRemainingPersistentAngerTime();
    }

    @Override
    public void setAnger(int level) {
        getHandle().setRemainingPersistentAngerTime(level);
    }

    @Override
    public void setAngry(boolean angry) {
        setAnger(angry ? 400 : 0);
    }

    @Override
    public boolean isAngry() {
        return getAnger() > 0;
    }

    @Override
    public EntityPigZombie getHandle() {
        return (EntityPigZombie) entity;
    }

    @Override
    public String toString() {
        return "CraftPigZombie";
    }

    @Override
    public boolean isConverting() {
        return false;
    }

    @Override
    public int getConversionTime() {
        throw new UnsupportedOperationException("Not supported by this Entity.");
    }

    @Override
    public void setConversionTime(int time) {
        throw new UnsupportedOperationException("Not supported by this Entity.");
    }
}
