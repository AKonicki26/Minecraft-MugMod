package com.mugmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;

public class MugEssence extends ModItem {
    public MugEssence(Settings settings) {
        super(settings, "mug_essence");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(this));

    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
