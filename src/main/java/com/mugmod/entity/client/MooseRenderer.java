package com.mugmod.entity.client;

import com.mugmod.MugMod;
import com.mugmod.entity.custom.MooseEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public class MooseRenderer extends MobEntityRenderer<MooseEntity, MooseModel<MooseEntity>> {
    private static final Identifier TEXTURE = new Identifier(MugMod.MOD_ID, "textures/entity/moose.png");

    public MooseRenderer(EntityRendererFactory.Context context) {
        super(context, new MooseModel<>(context.getPart(ModModelLayers.MOOSE)), 0.8f);
    }

    @Override
    public Identifier getTexture(MooseEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MooseEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
