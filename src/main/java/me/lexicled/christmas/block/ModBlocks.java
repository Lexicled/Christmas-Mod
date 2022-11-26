package me.lexicled.christmas.block;

import me.lexicled.christmas.Christmas;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CHRISTMAS_ORE_BLOCK = registerBlock("christmas_ore_block", new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
            ItemGroup.MATERIALS);
    public static final Block CHRISTMAS_ORE_BLOCK_DEEPSLATE = registerBlock("christmas_ore_block_deepslate", new Block(FabricBlockSettings.of(Material.STONE).strength(7f).requiresTool()),
            ItemGroup.MATERIALS);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Christmas.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Christmas.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        Christmas.LOGGER.debug("Blocks loaded for Christmas Mod!");
    }
}
