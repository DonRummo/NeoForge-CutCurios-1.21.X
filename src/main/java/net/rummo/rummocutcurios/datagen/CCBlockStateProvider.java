package net.rummo.rummocutcurios.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
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
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock)
    {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
