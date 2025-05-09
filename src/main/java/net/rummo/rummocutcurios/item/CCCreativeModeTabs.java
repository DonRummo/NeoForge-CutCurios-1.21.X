package net.rummo.rummocutcurios.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.CCBlocks;

import java.util.function.Supplier;

public class CCCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RummoCutCurios.MOD_ID);

    public static final Supplier<CreativeModeTab> CUTCURIOS_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("cutcurios_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rummocutcurios.cutcurios_items_tab"))
                    .icon(() -> new ItemStack(CCItems.RUBY.get())) /// MIGHT CHANGE LATER |||||||||||||||||||
                    .displayItems((pParameters, pOutput) -> {

                        /** INSERT HERE **/
                        pOutput.accept(CCItems.ROUGH_RUBY);
                        pOutput.accept(CCItems.RUBY);

                        pOutput.accept(CCItems.BAKED_APPLE);
                        pOutput.accept(CCItems.HONEY_DIPPED_APPLE);
                        pOutput.accept(CCItems.COCOA_DIPPED_APPLE);

                        pOutput.accept(Items.TURTLE_HELMET);
                        pOutput.accept(CCItems.TURTLE_CHESTPLATE);
                        pOutput.accept(CCItems.TURTLE_LEGGINGS);
                        pOutput.accept(CCItems.TURTLE_BOOTS);

                    }).build());

    public static final Supplier<CreativeModeTab> CUTCURIOS_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("cutcurios_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rummocutcurios.cutcurios_blocks_tab"))
                    .icon(() -> new ItemStack(CCBlocks.BASALTIC_RUBY_ORE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RummoCutCurios.MOD_ID, "cutcurios_items_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        /** INSERT HERE **/
                        pOutput.accept(CCBlocks.BASALTIC_RUBY_ORE);

                        pOutput.accept(CCBlocks.BASALT_BRICKS);
                        pOutput.accept(CCBlocks.CRACKED_BASALT_BRICKS);
                        pOutput.accept(CCBlocks.BASALT_BRICK_STAIRS);
                        pOutput.accept(CCBlocks.BASALT_BRICK_SLAB);
                        pOutput.accept(CCBlocks.BASALT_BRICK_WALL);

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
