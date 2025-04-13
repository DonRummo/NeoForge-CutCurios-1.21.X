package net.rummo.rummocutcurios.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.CCBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CCBlockTagProvider extends BlockTagsProvider
{

    public CCBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, RummoCutCurios.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CCBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(CCBlocks.BASALT_BRICKS.get())
                .add(CCBlocks.CRACKED_BASALT_BRICKS.get())
                .add(CCBlocks.BASALT_BRICK_STAIRS.get())
                .add(CCBlocks.BASALT_BRICK_SLAB.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(CCBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(CCBlocks.BASALT_BRICKS.get())
                .add(CCBlocks.CRACKED_BASALT_BRICKS.get())
                .add(CCBlocks.BASALT_BRICK_STAIRS.get())
                .add(CCBlocks.BASALT_BRICK_SLAB.get());

        tag(BlockTags.WALLS).add(CCBlocks.BASALT_BRICK_WALL.get());
    }
}
