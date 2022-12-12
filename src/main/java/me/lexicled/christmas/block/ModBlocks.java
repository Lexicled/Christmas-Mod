package me.lexicled.christmas.block;

import me.lexicled.christmas.Christmas;
import me.lexicled.christmas.block.custom.ChristmasPortalBlock;
import me.lexicled.christmas.block.custom.ChristmasTreeBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block CHRISTMAS_ORE_BLOCK = registerBlock("christmas_ore_block", new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ItemGroup.MATERIALS);
    public static final Block CHRISTMAS_ORE_BLOCK_DEEPSLATE = registerBlock("christmas_ore_block_deepslate", new Block(FabricBlockSettings.of(Material.STONE).strength(7f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)),
            ItemGroup.MATERIALS);

    public static final Block CHRISTMAS_TREE = registerBlock("christmas_tree", new ChristmasTreeBlock(FabricBlockSettings.of(Material.WOOD).strength(2f).nonOpaque().sounds(BlockSoundGroup.WOOD)),
            ItemGroup.DECORATIONS);

    public static final Block CHRISTMAS_PORTAL = registerBlock("christmas_portal", new ChristmasPortalBlock(FabricBlockSettings.of(Material.PORTAL).strength(50f).nonOpaque().noCollision()),
            ItemGroup.MISC);

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
