package com.mugmod.item;

import net.minecraft.item.ItemStack;

public class MugEssence extends ModItem {
    public MugEssence(Settings settings) {
        super(settings, "mug_essence");
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
