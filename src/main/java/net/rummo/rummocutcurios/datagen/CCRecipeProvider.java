package net.rummo.rummocutcurios.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.rummo.rummocutcurios.block.CCBlocks;
import net.rummo.rummocutcurios.item.CCItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CCRecipeProvider extends RecipeProvider implements IConditionBuilder
{

    public CCRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {

    }


}
