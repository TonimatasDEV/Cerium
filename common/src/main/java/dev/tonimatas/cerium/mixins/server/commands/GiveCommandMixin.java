package dev.tonimatas.cerium.mixins.server.commands;

import net.minecraft.server.commands.GiveCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GiveCommand.class)
public class GiveCommandMixin {
    @Redirect(method = "giveItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;drop(Lnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/entity/item/ItemEntity;", ordinal = 0))
    private static ItemEntity cerium$giveItem(ServerPlayer instance, ItemStack itemStack, boolean b) {
        return instance.drop(itemStack, false, false, false); // SPIGOT-2942: Add boolean to call event;
    }
}
