package com.mugmod;

import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.text.WordUtils;

public interface ModdedObject {

    public void registerObject();

    public ItemStack getItemStack();

    public default String getNameFromPath(String path) {
        return WordUtils.capitalizeFully(path.replace("_", " "));
    }
}
