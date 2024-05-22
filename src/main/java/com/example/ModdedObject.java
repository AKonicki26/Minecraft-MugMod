package com.example;

import net.minecraft.item.ItemStack;

public interface ModdedObject {

    public void registerObject();

    public String name = null;
    public String path = null;
    public ItemStack getItemStack();
}
