package com.example.item;

import com.example.ModdedObject;
import com.example.MugMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItemGroup {
    public static List<ModdedObject> MUG_ITEMS = new ArrayList<>();
    public static final ItemGroup MUG_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(MugMod.MOD_ID, "mug"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.mug"))
                    .icon(() -> new ItemStack(ModItem.MUG_ESSENCE))
                    .entries((displayContext, entries) -> {
                        MUG_ITEMS.forEach(moddedObject -> {
                            entries.add(moddedObject.getItemStack());
                        });
                    })
                    .build());

    public static void registerItemGroups() {
        MugMod.LOGGER.info("Registering Item Groups for " + MugMod.MOD_ID);
    }
}
