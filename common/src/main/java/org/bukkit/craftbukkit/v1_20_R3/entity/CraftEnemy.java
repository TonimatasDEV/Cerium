package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.monster.IMonster;
import org.bukkit.entity.Enemy;

public interface CraftEnemy extends Enemy {

    IMonster getHandle();
}
