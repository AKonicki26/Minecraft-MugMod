package com.mugmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class FoodComponents {
    public static final FoodComponent MugCan = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1200,4),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1200,3),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 1200,127),1)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 180,3),0.5f)
            .build();

}