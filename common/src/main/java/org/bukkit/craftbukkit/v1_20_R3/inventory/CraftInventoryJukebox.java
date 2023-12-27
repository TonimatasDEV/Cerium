package org.bukkit.craftbukkit.v1_20_R3.inventory;

import dev.tonimatas.cerium.bridge.world.ContainerBridge;
import net.minecraft.world.Container;
import org.bukkit.block.Jukebox;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.JukeboxInventory;

public class CraftInventoryJukebox extends CraftInventory implements JukeboxInventory {

    public CraftInventoryJukebox(Container inventory) {
        super(inventory);
    }

    @Override
    public void setRecord(ItemStack item) {
        if (item == null) {
            inventory.removeItem(0, 0); // Second parameter is unused in BlockEntityJukebox
        } else {
            setItem(0, item);
        }
    }

    @Override
    public ItemStack getRecord() {
        return getItem(0);
    }

    @Override
    public Jukebox getHolder() {
        return (Jukebox) ((ContainerBridge) inventory).getOwner();
    }
}
