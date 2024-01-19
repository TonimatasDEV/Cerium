package dev.tonimatas.cerium.util;

import joptsimple.OptionSet;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import org.bukkit.World;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.spongepowered.asm.mixin.injection.At;

import java.util.concurrent.atomic.AtomicReference;

public class CeriumValues {
    public static BlockPos openSign; // CraftBukkit
    public static AtomicReference<EntityPotionEffectEvent.Cause> potionEffectCause = new AtomicReference<>(EntityPotionEffectEvent.Cause.UNKNOWN); // CraftBukkit
    public static AtomicReference<OptionSet> optionSet = new AtomicReference<>(null);
    public static final LootContextParam<Integer> LOOTING_MOD = new LootContextParam<>(new ResourceLocation("bukkit:looting_mod")); // CraftBukkit
    public static CeriumClasses.WorldInfo worldInfo = null;
    public static ResourceKey<LevelStem> dimensionType = null;
}
