package com.mugmod.item;

import com.mugmod.MugMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItemGroup {
    public static List<Item> MUG_ITEMS = new ArrayList<Item>();
    public static final ItemGroup MUG_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(MugMod.MOD_ID, "mug"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.mug"))
                    .icon(() -> new ItemStack(ModItem.MUG_ESSENCE))
                    .entries((displayContext, entries) -> {
                        MUG_ITEMS.forEach(entries::add);
                    })
                    .build());

    public static void registerItemGroups() {
        MugMod.LOGGER.info("Registering Item Groups for " + MugMod.MOD_ID);
    }
}
