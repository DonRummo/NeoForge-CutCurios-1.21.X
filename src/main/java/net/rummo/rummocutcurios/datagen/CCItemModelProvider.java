package net.rummo.rummocutcurios.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.CCBlocks;
import net.rummo.rummocutcurios.item.CCItems;

public class CCItemModelProvider extends ItemModelProvider
{

    public CCItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, RummoCutCurios.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        basicItem(CCItems.ROUGH_RUBY.get());
        basicItem(CCItems.RUBY.get());

        basicItem(CCItems.BAKED_APPLE.get());
        basicItem(CCItems.HONEY_DIPPED_APPLE.get());
        basicItem(CCItems.COCOA_DIPPED_APPLE.get());

        basicItem(CCItems.TURTLE_CHESTPLATE.get());
        basicItem(CCItems.TURTLE_LEGGINGS.get());
        basicItem(CCItems.TURTLE_BOOTS.get());

        wallItem(CCBlocks.BASALT_BRICK_WALL, CCBlocks.BASALT_BRICKS);
    }

    public void wallItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock)
    {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(RummoCutCurios.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
