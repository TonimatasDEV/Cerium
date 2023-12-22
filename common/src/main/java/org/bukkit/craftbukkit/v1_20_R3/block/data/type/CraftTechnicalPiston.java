package org.bukkit.craftbukkit.v1_20_R3.block.data.type;

import org.bukkit.block.data.type.TechnicalPiston;
import org.bukkit.craftbukkit.v1_20_R3.block.data.CraftBlockData;

public abstract class CraftTechnicalPiston extends CraftBlockData implements TechnicalPiston {

    private static final net.minecraft.world.level.block.state.properties.BlockStateEnum<?> TYPE = getEnum("type");

    @Override
    public org.bukkit.block.data.type.TechnicalPiston.Type getType() {
        return get(TYPE, org.bukkit.block.data.type.TechnicalPiston.Type.class);
    }

    @Override
    public void setType(org.bukkit.block.data.type.TechnicalPiston.Type type) {
        set(TYPE, type);
    }
}
