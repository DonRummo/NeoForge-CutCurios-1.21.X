package net.rummo.rummocutcurios.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class CCFoodProperties
{
    public static final FoodProperties BAKED_APPLE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .build();
    public static final FoodProperties HONEY_DIPPED_APPLE = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100), 0.5f)
            .build();
    public static final FoodProperties COCOA_DIPPED_APPLE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.5f)
            .build();
}
