package com.mugmod.entity;

import com.mugmod.MugMod;
import com.mugmod.entity.custom.MooseEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<MooseEntity> MOOSE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MugMod.MOD_ID, "moose"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MooseEntity::new).dimensions(EntityDimensions.fixed(2.25f,2.25f)).build());
}
