package net.rummo.rummocutcurios.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.rummo.rummocutcurios.RummoCutCurios;

import java.util.EnumMap;
import java.util.List;

public class CCArmorMaterials
{
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, RummoCutCurios.MOD_ID);

    public static final Holder<ArmorMaterial> TURTLE =
            ARMOR_MATERIALS.register("turtle", () -> new ArmorMaterial(
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.BOOTS, 2);
                    }), 9, SoundEvents.ARMOR_EQUIP_TURTLE, () -> Ingredient.of(Items.TURTLE_SCUTE),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(RummoCutCurios.MOD_ID, "turtle"))),
                    5.5f, 0.5f
            ));

    public static void register(IEventBus eventBus)
    {
        ARMOR_MATERIALS.register(eventBus);
    }
}
