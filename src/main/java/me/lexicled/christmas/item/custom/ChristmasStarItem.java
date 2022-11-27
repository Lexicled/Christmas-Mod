package me.lexicled.christmas.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ChristmasStarItem extends Item {
    public ChristmasStarItem(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
