package com.mugmod.entity.client;

import com.mugmod.entity.animation.ModAnimations;
import com.mugmod.entity.custom.MooseEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

public class MooseModel  <T extends MooseEntity> extends SinglePartEntityModel<T> {
	private final ModelPart root;
	private final ModelPart head;

	public MooseModel(ModelPart root) {
		this.root = root.getChild("root");
		this.head = root.getChild("root").getChild("body").getChild("head");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = root.addChild("body", ModelPartBuilder.create().uv(0, 33).cuboid(-6.5F, -14.0F, -9.0F, 13.0F, 14.0F, 13.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-6.5F, -18.0F, -23.0F, 13.0F, 18.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 8.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(39, 47).cuboid(-3.5F, -5.0F, -11.0F, 7.0F, 13.0F, 14.0F, new Dilation(0.0F))
				.uv(0, 84).cuboid(-3.5F, -5.0F, -18.0F, 7.0F, 7.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 7).cuboid(-3.5F, -8.0F, -14.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(2.5F, -8.0F, -14.0F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F))
				.uv(0, 61).cuboid(-12.5F, -13.0F, -21.0F, 9.0F, 8.0F, 14.0F, new Dilation(0.0F))
				.uv(41, 19).cuboid(3.5F, -13.0F, -21.0F, 9.0F, 8.0F, 14.0F, new Dilation(0.0F))
				.uv(29, 84).cuboid(0.0F, 1.0F, -20.0F, 0.0F, 9.0F, 7.0F, new Dilation(0.0F))
				.uv(41, 0).cuboid(-2.5F, -4.0F, -25.0F, 5.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -11.0F, -20.0F));

		ModelPartData right_front_leg = root.addChild("right_front_leg", ModelPartBuilder.create().uv(82, 42).cuboid(-2.5F, 2.0F, -2.5F, 5.0F, 19.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.pivot(-4.0F, -21.0F, -11.5F));

		ModelPartData left_front_leg = root.addChild("left_front_leg", ModelPartBuilder.create().uv(68, 75).cuboid(-2.5F, 2.0F, -2.5F, 5.0F, 19.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.pivot(4.0F, -21.0F, -11.5F));

		ModelPartData left_hind_leg = root.addChild("left_hind_leg", ModelPartBuilder.create().uv(74, 0).cuboid(-2.5F, 2.0F, -2.5F, 5.0F, 19.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.pivot(4.0F, -21.0F, 8.5F));

		ModelPartData right_hind_leg = root.addChild("right_hind_leg", ModelPartBuilder.create().uv(47, 75).cuboid(-2.5F, 2.0F, -2.5F, 5.0F, 19.0F, 5.0F, new Dilation(-0.01F)), ModelTransform.pivot(-4.0F, -21.0F, 8.5F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return root;
	}

	@Override
	public void setAngles(MooseEntity entity, float limbAngle, float limbDistance, float animationProgress, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.MOOSE_WALK, limbAngle, limbDistance, 2.0F, 2.5F);
		this.updateAnimation(entity.idleAnimationState,ModAnimations.MOOSE_IDLE, animationProgress, 1f );
		this.updateAnimation(entity.attackAnimationState, ModAnimations.MOOSE_ATTACK, 0, 1.0F);

	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * 0.017453292f;
		this.head.pitch = headPitch * 0.017453292f;
	}
}