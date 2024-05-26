package com.mugmod.datagen;

import com.mugmod.blocks.ModBlock;
import com.mugmod.item.ModItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.OptionalInt;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.NETHER_MUG_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlock.Block_Test);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItem.MUG_ROOT_BEER, Models.GENERATED);
        itemModelGenerator.register(ModItem.MUG_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItem.AW_ROOT_BEER, Models.GENERATED);
        itemModelGenerator.register(ModItem.FALCONRY_GLOVE, Models.GENERATED);

        itemModelGenerator.register(ModItem.MOOSE_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));


    }
}
