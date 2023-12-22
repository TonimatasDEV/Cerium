package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.monster.EntityEvoker;
import net.minecraft.world.entity.monster.EntityIllagerWizard;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.entity.Evoker;

public class CraftEvoker extends CraftSpellcaster implements Evoker {

    public CraftEvoker(CraftServer server, EntityEvoker entity) {
        super(server, entity);
    }

    @Override
    public EntityEvoker getHandle() {
        return (EntityEvoker) super.getHandle();
    }

    @Override
    public String toString() {
        return "CraftEvoker";
    }

    @Override
    public Evoker.Spell getCurrentSpell() {
        return Evoker.Spell.values()[getHandle().getCurrentSpell().ordinal()];
    }

    @Override
    public void setCurrentSpell(Evoker.Spell spell) {
        getHandle().setIsCastingSpell(spell == null ? EntityIllagerWizard.Spell.NONE : EntityIllagerWizard.Spell.byId(spell.ordinal()));
    }
}
