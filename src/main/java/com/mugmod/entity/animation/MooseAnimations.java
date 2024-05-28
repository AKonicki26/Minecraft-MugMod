package com.mugmod.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class MooseAnimations {

//MOOSE

    public static final Animation MOOSE_WALK = Animation.Builder.create(1.5f).looping()
            .addBoneAnimation("root",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 1.75f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, -1.75f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 1.75f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.375f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.125f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("right_front_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.4583f, AnimationHelper.createTranslationalVector(0f, 4f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("right_front_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(-22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("left_front_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.2083f, AnimationHelper.createTranslationalVector(0f, 4f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("left_front_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(-22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("left_hind_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.21f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.0833f, AnimationHelper.createTranslationalVector(0f, 4f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.375f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, -0.21f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left_hind_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-20.4f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.375f, AnimationHelper.createRotationalVector(-22.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(-20.4f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("right_hind_leg",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.375f, AnimationHelper.createTranslationalVector(0f, 4f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC)))
            .addBoneAnimation("right_hind_leg",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.625f, AnimationHelper.createRotationalVector(-22.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(1.5f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),

                                    Transformation.Interpolations.CUBIC))).build();

    public static final Animation MOOSE_IDLE = Animation.Builder.create(4f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(2f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(4f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC))).build();


    public static final Animation MOOSE_ATTACK = Animation.Builder.create(0.5f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(17.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.08343333f, AnimationHelper.createRotationalVector(35f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.20834334f, AnimationHelper.createRotationalVector(-90.5f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC),
                            new Keyframe(0.375f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.CUBIC))).build();

}
