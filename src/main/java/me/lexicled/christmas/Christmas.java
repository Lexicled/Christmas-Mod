package me.lexicled.christmas;

import me.lexicled.christmas.block.ModBlocks;
import me.lexicled.christmas.entity.ModEntities;
import me.lexicled.christmas.entity.custom.SantaEntity;
import me.lexicled.christmas.item.ModItems;
import me.lexicled.christmas.world.feature.ModConfiguredFeatures;
import me.lexicled.christmas.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class Christmas implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("christmas");
	public static String MOD_ID = "christmas";

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGen.generateModWorldGen();
		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.SANTA, SantaEntity.setAttributes());
	}
}
