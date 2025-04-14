package net.rummo.rummocutcurios.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.rummo.rummocutcurios.item.CCArmorMaterials;

import java.util.List;
import java.util.Map;

public class CCArmorItem extends ArmorItem
{
    public static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(CCArmorMaterials.TURTLE, List.of(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200, 0, false, false),
                            new MobEffectInstance(MobEffects.WATER_BREATHING, 200, 0, false, false),
                            new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1, false, false)))
                    .build();

    public CCArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties)
    {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(pEntity instanceof Player player) {
            if(!pLevel.isClientSide() && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }


    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    /// Infinite Effect Time
    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        for (MobEffectInstance effect : mapEffect) {
            MobEffectInstance currentEffect = player.getEffect(effect.getEffect());
            // Apply if effect doesn't exist or is about to expire (e.g., < 10 ticks left)
            if (currentEffect == null || currentEffect.getDuration() < 10) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }


    /// Normal Effect Time
//    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
//        boolean hasPlayerEffect = mapEffect.stream().anyMatch(effect -> player.hasEffect(effect.getEffect()));
//
//        if(!hasPlayerEffect) {
//            for (MobEffectInstance effect : mapEffect) {
//                player.addEffect(new MobEffectInstance(effect.getEffect(),
//                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
//            }
//        }
//    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        /// Newly Added BELOW
        ItemStack helmetStack = player.getInventory().getArmor(3);
        ArmorItem helmet = helmetStack.getItem() instanceof ArmorItem armor ? armor : null;

        // Accept either the custom turtle material helmet or the vanilla turtle helmet
        boolean isValidHelmet = helmet != null && (
                helmet.getMaterial() == mapArmorMaterial ||
                        helmetStack.is(Items.TURTLE_HELMET) // allow vanilla turtle shell
        );

        return boots.getMaterial() == mapArmorMaterial &&
                leggings.getMaterial() == mapArmorMaterial &&
                chestplate.getMaterial() == mapArmorMaterial &&
                isValidHelmet;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}
