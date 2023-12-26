package dev.tonimatas.cerium.mixins.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.TreeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FungusBlock.class)
public abstract class FungusBlockMixin {
    @SuppressWarnings("ConstantConditions")
    @Inject(method = "performBonemeal", at = @At("HEAD"))
    private void cerium$captureTree(ServerLevel worldIn, RandomSource rand, BlockPos pos, BlockState state, CallbackInfo ci) {
        if ((Object) this == Blocks.WARPED_FUNGUS) {
            SaplingBlock.treeType = TreeType.WARPED_FUNGUS;
        } else if ((Object) this == Blocks.CRIMSON_FUNGUS) {
            SaplingBlock.treeType = TreeType.CRIMSON_FUNGUS;
        }
    }
}
