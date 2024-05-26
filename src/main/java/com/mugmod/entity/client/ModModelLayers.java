package com.mugmod.entity.client;

import com.mugmod.MugMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {

    public static final EntityModelLayer MOOSE =
            new EntityModelLayer(new Identifier(MugMod.MOD_ID, "moose"), "main");
}
