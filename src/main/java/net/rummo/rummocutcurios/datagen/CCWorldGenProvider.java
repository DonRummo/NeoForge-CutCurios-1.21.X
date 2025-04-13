package net.rummo.rummocutcurios.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.rummo.rummocutcurios.RummoCutCurios;
import net.rummo.rummocutcurios.worldgen.CCBiomeModifier;
import net.rummo.rummocutcurios.worldgen.CCConfiguredFeatures;
import net.rummo.rummocutcurios.worldgen.CCPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CCWorldGenProvider extends DatapackBuiltinEntriesProvider
{
public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, CCConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, CCPlacedFeatures::bootstrap)
        .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CCBiomeModifier::bootstrap);

    public CCWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, BUILDER, Set.of(RummoCutCurios.MOD_ID));
    }
}
