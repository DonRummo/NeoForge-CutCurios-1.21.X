package net.rummo.rummocutcurios.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.rummo.rummocutcurios.RummoCutCurios;
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
        List<ItemLike> BASALT_SMELTABLES = List.of(CCBlocks.BASALT_BRICKS);
        /** SHAPED **/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, CCBlocks.BASALT_BRICKS.get(), 4)
                        .pattern("SS")
                        .pattern("SS")
                        .define('S', Items.SMOOTH_BASALT)
                        .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT)).save(recipeOutput);

        /** SMELTING **/
        oreSmelting(recipeOutput, BASALT_SMELTABLES, RecipeCategory.BUILDING_BLOCKS, CCBlocks.CRACKED_BASALT_BRICKS.get(), 0.25f, 200, "cracked_basalt_bricks");

        /** STONECUTTER **/
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(CCItems.ROUGH_RUBY), RecipeCategory.MISC, CCItems.RUBY, 1)
                .unlockedBy("has_rough_ruby", has(CCItems.ROUGH_RUBY))
                .save(recipeOutput, "ruby_from_rough_ruby_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_BASALT), RecipeCategory.BUILDING_BLOCKS, CCBlocks.BASALT_BRICKS, 1)
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(recipeOutput, "basalt_bricks_from_smooth_basalt_stonecutting");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(CCBlocks.BASALT_BRICKS), RecipeCategory.BUILDING_BLOCKS, CCBlocks.BASALT_BRICK_STAIRS, 1)
                .unlockedBy("has_basalt_bricks", has(CCBlocks.BASALT_BRICKS))
                .save(recipeOutput, "basalt_brick_stairs_from_basalt_bricks_stonecutting");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(CCBlocks.BASALT_BRICKS), RecipeCategory.BUILDING_BLOCKS, CCBlocks.BASALT_BRICK_SLAB, 2)
                .unlockedBy("has_basalt_bricks", has(CCBlocks.BASALT_BRICKS))
                .save(recipeOutput, "basalt_brick_slab_from_basalt_bricks_stonecutting");

        /** STAIRS & SLABS **/
        stairBuilder(CCBlocks.BASALT_BRICK_STAIRS.get(), Ingredient.of(CCBlocks.BASALT_BRICKS.get())).group("basalt_bricks")
                .unlockedBy("has_basalt_bricks", has(CCBlocks.BASALT_BRICKS.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, CCBlocks.BASALT_BRICK_SLAB.get(), CCBlocks.BASALT_BRICKS.get());
    }

    /* DO NOT TOUCH */

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup)
    {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup)
    {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, RummoCutCurios.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
