package net.rummo.rummocutcurios.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
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

                    }).build());

    public static final Supplier<CreativeModeTab> CUTCURIOS_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("cutcurios_blocks_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.rummocutcurios.cutcurios_blocks_tab"))
                    .icon(() -> new ItemStack(CCBlocks.DEEPSLATE_RUBY_ORE))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RummoCutCurios.MOD_ID, "cutcurios_items_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        /** INSERT HERE **/
                        pOutput.accept(CCBlocks.DEEPSLATE_RUBY_ORE);

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
