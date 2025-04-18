package net.rummo.rummocutcurios.block;

import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.custom.ExperiencePillarBlock;
import net.rummo.rummocutcurios.item.CCItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CCBlocks
{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(RummoCutCurios.MOD_ID);

    /** BLOCKS GO HERE **/

    public static final DeferredBlock<Block> BASALTIC_RUBY_ORE = registerBlock("basaltic_ruby_ore",
            () -> new ExperiencePillarBlock(UniformInt.of(5, 8), BlockBehaviour.Properties.of()
                    .sound(SoundType.BASALT)
                    .strength(2.25f, 4.2f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BASALT_BRICKS = registerBlock("basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.BASALT)
                    .strength(1.25f, 4.2f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CRACKED_BASALT_BRICKS = registerBlock("cracked_basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.BASALT)
                    .strength(1.25f, 4.2f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BASALT_BRICK_STAIRS = registerBlock("basalt_brick_stairs",
            () -> new StairBlock(CCBlocks.BASALT_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .sound(SoundType.BASALT)
                            .strength(1.25f, 4.2f)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BASALT_BRICK_SLAB = registerBlock("basalt_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.BASALT)
                    .strength(1.25f, 4.2f)
                    .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> BASALT_BRICK_WALL = registerBlock("basalt_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.BASALT)
                    .strength(1.25f, 4.2f)
                    .requiresCorrectToolForDrops()));

    /** DO NOT GO BEYOND THIS POINT **/

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        CCItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
