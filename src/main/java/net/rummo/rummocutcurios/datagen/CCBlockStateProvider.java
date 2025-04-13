package net.rummo.rummocutcurios.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.CCBlocks;

public class CCBlockStateProvider extends BlockStateProvider
{

    public CCBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, RummoCutCurios.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(CCBlocks.DEEPSLATE_RUBY_ORE);

        blockWithItem(CCBlocks.BASALT_BRICKS);
        blockWithItem(CCBlocks.CRACKED_BASALT_BRICKS);

        stairsBlock(((StairBlock) CCBlocks.BASALT_BRICK_STAIRS.get()), blockTexture(CCBlocks.BASALT_BRICKS.get()));
        slabBlock(((SlabBlock) CCBlocks.BASALT_BRICK_SLAB.get()), blockTexture(CCBlocks.BASALT_BRICKS.get()), blockTexture(CCBlocks.BASALT_BRICKS.get()));
        blockItem(CCBlocks.BASALT_BRICK_STAIRS);
        blockItem(CCBlocks.BASALT_BRICK_SLAB);

        wallBlock(((WallBlock) CCBlocks.BASALT_BRICK_WALL.get()), blockTexture(CCBlocks.BASALT_BRICKS.get()));
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("rummocutcurios:block/" + deferredBlock.getId().getPath()));
    }
}
