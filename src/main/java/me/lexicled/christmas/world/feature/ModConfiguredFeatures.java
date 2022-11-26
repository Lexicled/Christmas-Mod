package me.lexicled.christmas.world.feature;

import me.lexicled.christmas.block.ModBlocks;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> OVERWORLD_CHRISTMAS_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.CHRISTMAS_ORE_BLOCK.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.CHRISTMAS_ORE_BLOCK_DEEPSLATE.getDefaultState()));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CHRISTMAS_ORE_BLOCK =
            ConfiguredFeatures.register("christmas:christmas_ore_block", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_CHRISTMAS_ORES, 9));

    public static void registerConfiguredFeatures() {
        System.out.println("Registering generation features for Christmas Mod!");
    }
}
