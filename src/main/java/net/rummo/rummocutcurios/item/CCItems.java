package net.rummo.rummocutcurios.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rummo.rummocutcurios.RummoCutCurios;

public class CCItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RummoCutCurios.MOD_ID);

    /** ITEMS GO HERE **/

    public static final DeferredItem<Item> RAW_RUBY =
            ITEMS.registerItem("raw_ruby", Item::new, new Item.Properties());

    /** DO NOT GO BEYOND THIS POINT **/

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
