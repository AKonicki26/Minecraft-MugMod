package com.mugmod.mixin;

import com.mugmod.MugMod;
import com.mugmod.item.ModItem;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useParasolModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumer, int light, int overlay) {
        if (stack.isOf(ModItem.PARASOL) && renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MugMod.MOD_ID, "parasol_3d", "inventory"));
        } else if (stack.isOf(ModItem.PARASOL) && renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MugMod.MOD_ID, "parasol_3d", "inventory"));
        }else if (stack.isOf(ModItem.PARASOL) && renderMode == ModelTransformationMode.THIRD_PERSON_LEFT_HAND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MugMod.MOD_ID, "parasol_3d", "inventory"));
        }else if (stack.isOf(ModItem.PARASOL) && renderMode == ModelTransformationMode.THIRD_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MugMod.MOD_ID, "parasol_3d", "inventory"));
        }
        return value;
    }
//
//    public BakedModel useToxicGauntletModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumer, int light, int overlay) {
//        if (stack.isOf(ModItem.TOXICGAUNTLET)) {
//            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(MugMod.MOD_ID, "toxic_gauntlet_3d", "inventory"));
//        }
//        return value;
//    }
}
