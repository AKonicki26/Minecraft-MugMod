package com.mugmod;

import com.mugmod.entity.ModEntities;
import com.mugmod.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class MugModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.MOOSE, MooseRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOOSE, MooseModel::getTexturedModelData);

    }
}
