package net.rummo.rummocutcurios.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.block.CCBlocks;
import net.rummo.rummocutcurios.item.custom.CCArmorItem;

public class CCItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RummoCutCurios.MOD_ID);

    /** ITEMS GO HERE **/

    public static final DeferredItem<Item> ROUGH_RUBY =
            ITEMS.registerItem("rough_ruby", Item::new, new Item.Properties().fireResistant());
    public static final DeferredItem<Item> RUBY =
            ITEMS.registerItem("ruby", Item::new, new Item.Properties().fireResistant());

    public static final DeferredItem<Item> BAKED_APPLE =
            ITEMS.registerItem("baked_apple", Item::new, new Item.Properties()
                    .food(CCFoodProperties.BAKED_APPLE));
    public static final DeferredItem<Item> HONEY_DIPPED_APPLE =
            ITEMS.registerItem("honey_dipped_apple", Item::new, new Item.Properties()
                    .food(CCFoodProperties.HONEY_DIPPED_APPLE));
    public static final DeferredItem<Item> COCOA_DIPPED_APPLE =
            ITEMS.registerItem("cocoa_dipped_apple", Item::new, new Item.Properties()
                    .food(CCFoodProperties.COCOA_DIPPED_APPLE));

    public static final DeferredItem<Item> TURTLE_CHESTPLATE =
            ITEMS.register("turtle_chestplate",
                    () -> new CCArmorItem(CCArmorMaterials.TURTLE, ArmorItem.Type.CHESTPLATE,
                            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));
    public static final DeferredItem<Item> TURTLE_LEGGINGS =
            ITEMS.register("turtle_leggings",
                    () -> new CCArmorItem(CCArmorMaterials.TURTLE, ArmorItem.Type.LEGGINGS,
                            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final DeferredItem<Item> TURTLE_BOOTS =
            ITEMS.register("turtle_boots",
                    () -> new CCArmorItem(CCArmorMaterials.TURTLE, ArmorItem.Type.BOOTS,
                            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(13))));



    /** DO NOT GO BEYOND THIS POINT **/

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
