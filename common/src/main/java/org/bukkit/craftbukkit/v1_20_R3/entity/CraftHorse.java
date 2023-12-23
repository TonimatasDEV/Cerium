package org.bukkit.craftbukkit.v1_20_R3.entity;

import com.google.common.base.Preconditions;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftInventoryHorse;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.HorseInventory;

public class CraftHorse extends CraftAbstractHorse implements Horse {

    public CraftHorse(CraftServer server, net.minecraft.world.entity.animal.horse.Horse entity) {
        super(server, entity);
    }

    @Override
    public net.minecraft.world.entity.animal.horse.Horse getHandle() {
        return (net.minecraft.world.entity.animal.horse.Horse) super.getHandle();
    }

    @Override
    public Variant getVariant() {
        return Variant.HORSE;
    }

    @Override
    public Color getColor() {
        return Color.values()[getHandle().getVariant().getId()];
    }

    @Override
    public void setColor(Color color) {
        Preconditions.checkArgument(color != null, "Color cannot be null");
        getHandle().setVariantAndMarkings(net.minecraft.world.entity.animal.horse.Variant.byId(color.ordinal()), getHandle().getMarkings());
    }

    @Override
    public Style getStyle() {
        return Style.values()[getHandle().getMarkings().getId()];
    }

    @Override
    public void setStyle(Style style) {
        Preconditions.checkArgument(style != null, "Style cannot be null");
        getHandle().setVariantAndMarkings(getHandle().getVariant(), net.minecraft.world.entity.animal.horse.Variant.byId(style.ordinal()));
    }

    @Override
    public boolean isCarryingChest() {
        return false;
    }

    @Override
    public void setCarryingChest(boolean chest) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public HorseInventory getInventory() {
        return new CraftInventoryHorse(getHandle().inventory);
    }

    @Override
    public String toString() {
        return "CraftHorse{variant=" + getVariant() + ", owner=" + getOwner() + '}';
    }
}