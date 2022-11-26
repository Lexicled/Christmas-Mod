package me.lexicled.christmas.item;

import me.lexicled.christmas.Christmas;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CHRISTMAS_ORE = registerItem("christmas_ore", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Christmas.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Christmas.LOGGER.debug("Registering mod items for Christmas Mod!");
    }
}
