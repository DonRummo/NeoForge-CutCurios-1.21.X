package net.rummo.rummocutcurios.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.CCBlocks;

public class CCItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RummoCutCurios.MOD_ID);

    /** ITEMS GO HERE **/

    public static final DeferredItem<Item> ROUGH_RUBY =
            ITEMS.registerItem("rough_ruby", Item::new, new Item.Properties().fireResistant());
    public static final DeferredItem<Item> RUBY =
            ITEMS.registerItem("ruby", Item::new, new Item.Properties().fireResistant());



    /** DO NOT GO BEYOND THIS POINT **/

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
