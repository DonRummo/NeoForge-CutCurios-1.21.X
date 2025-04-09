package net.rummo.rummocutcurios.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.rummo.rummocutcurios.block.CCBlocks;
import net.rummo.rummocutcurios.item.CCItems;

import java.util.Set;

public class CCBlockLootTableProvider extends BlockLootSubProvider
{
    // Constructor
    protected CCBlockLootTableProvider(HolderLookup.Provider provider)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate()
    {
        this.add(CCBlocks.DEEPSLATE_RUBY_ORE.get(),
                block -> createMultipleOreDrops(CCBlocks.DEEPSLATE_RUBY_ORE.get(), CCItems.RAW_RUBY.get(), 1, 3));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops)
    {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }



    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return CCBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
