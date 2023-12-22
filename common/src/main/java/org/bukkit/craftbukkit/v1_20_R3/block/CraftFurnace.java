package org.bukkit.craftbukkit.v1_20_R3.block;

import com.google.common.collect.ImmutableMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Furnace;
import org.bukkit.craftbukkit.v1_20_R3.inventory.CraftInventoryFurnace;
import org.bukkit.craftbukkit.v1_20_R3.util.CraftNamespacedKey;
import org.bukkit.inventory.CookingRecipe;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.Recipe;

import java.util.Map;

public abstract class CraftFurnace<T extends AbstractFurnaceBlockEntity> extends CraftContainer<T> implements Furnace {

    public CraftFurnace(World world, T tileEntity) {
        super(world, tileEntity);
    }

    protected CraftFurnace(CraftFurnace<T> state) {
        super(state);
    }

    @Override
    public FurnaceInventory getSnapshotInventory() {
        return new CraftInventoryFurnace(this.getSnapshot());
    }

    @Override
    public FurnaceInventory getInventory() {
        if (!this.isPlaced()) {
            return this.getSnapshotInventory();
        }

        return new CraftInventoryFurnace(this.getBlockEntity());
    }

    @Override
    public short getBurnTime() {
        return (short) this.getSnapshot().litTime;
    }

    @Override
    public void setBurnTime(short burnTime) {
        this.getSnapshot().litTime = burnTime;
        // SPIGOT-844: Allow lighting and relighting using this API
        this.data = this.data.setValue(FurnaceBlock.LIT, burnTime > 0);
    }

    @Override
    public short getCookTime() {
        return (short) this.getSnapshot().cookingProgress;
    }

    @Override
    public void setCookTime(short cookTime) {
        this.getSnapshot().cookingProgress = cookTime;
    }

    @Override
    public int getCookTimeTotal() {
        return this.getSnapshot().cookingTotalTime;
    }

    @Override
    public void setCookTimeTotal(int cookTimeTotal) {
        this.getSnapshot().cookingTotalTime = cookTimeTotal;
    }

    @Override
    public Map<CookingRecipe<?>, Integer> getRecipesUsed() {
        ImmutableMap.Builder<CookingRecipe<?>, Integer> recipesUsed = ImmutableMap.builder();
        for (Map.Entry<ResourceLocation, Integer> entrySet : this.getSnapshot().getRecipesUsed().object2IntEntrySet()) {
            Recipe recipe = Bukkit.getRecipe(CraftNamespacedKey.fromMinecraft(entrySet.getKey()));
            if (recipe instanceof CookingRecipe<?> cookingRecipe) {
                recipesUsed.put(cookingRecipe, entrySet.getValue());
            }
        }

        return recipesUsed.build();
    }

    @Override
    public abstract CraftFurnace<T> copy();
}
