package me.lexicled.christmas.item;

import me.lexicled.christmas.Christmas;
import me.lexicled.christmas.item.custom.ChristmasStaffItem;
import me.lexicled.christmas.item.custom.ChristmasStarItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item CHRISTMAS_ORE = registerItem("christmas_ore", new Item(new FabricItemSettings().group(ItemGroup.MATERIALS)));

    public static final Item CHRISTMAS_SWORD = registerItem("christmas_sword", new SwordItem(ModToolMaterials.CHRISTMAS, 2, 5f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item CHRISTMAS_AXE = registerItem("christmas_axe", new AxeItem(ModToolMaterials.CHRISTMAS, 3, 9f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item CHRISTMAS_PICKAXE = registerItem("christmas_pickaxe", new PickaxeItem(ModToolMaterials.CHRISTMAS, 1, 12f, new FabricItemSettings().group(ItemGroup.TOOLS)));
    public static final Item CHRISTMAS_STAFF_INACTIVE = registerItem("christmas_staff_inactive", new Item(new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.RARE)));
    public static final Item CHRISTMAS_STAFF_ACTIVE = registerItem("christmas_staff_active", new ChristmasStaffItem(new FabricItemSettings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC)));
    public static final Item CHRISTMAS_STAR = registerItem("christmas_star", new ChristmasStarItem(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Christmas.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Christmas.LOGGER.debug("Registering mod items for Christmas Mod!");
    }
}
