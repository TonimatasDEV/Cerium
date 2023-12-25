package dev.tonimatas.cerium.mixins.world;

import net.minecraft.world.LockCode;
import net.minecraft.world.item.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_20_R3.util.CraftChatMessage;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(LockCode.class)
public class LockCodeMixin {
    @Shadow @Final public String key;

    /**
     * @author TonimatasDEV
     * @reason CraftBukkit
     */
    @Overwrite
    public boolean unlocksWith(ItemStack itemStack) {
        // CraftBukkit start - SPIGOT-6307: Check for color codes if the lock contains color codes
        if (this.key.isEmpty()) return true;
        if (!itemStack.isEmpty() && itemStack.hasCustomHoverName()) {
            if (this.key.indexOf(ChatColor.COLOR_CHAR) == -1) {
                // The lock key contains no color codes, so let's ignore colors in the item display name (vanilla Minecraft behavior):
                return this.key.equals(itemStack.getHoverName().getString());
            } else {
                // The lock key contains color codes, so let's take them into account:
                return this.key.equals(CraftChatMessage.fromComponent(itemStack.getHoverName()));
            }
        }
        return false;
        // CraftBukkit end
    }
}
