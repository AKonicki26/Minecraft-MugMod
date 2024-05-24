package com.mugmod;

import net.minecraft.item.ItemStack;

public interface ModdedObject {

    public void registerObject();

    public ItemStack getItemStack();
}
