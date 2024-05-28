package com.mugmod.entity.custom;

import com.mugmod.entity.ModEntities;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class MooseEntity extends AnimalEntity implements Angerable {

    public MooseEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);    }

    //Animations

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <=0){
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else{
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && this.attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 10;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
            if (!this.isAttacking()) {
                attackAnimationState.stop();
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
        if (!this.getWorld().isClient) {
            this.tickAngerLogic((ServerWorld)this.getWorld(), true);
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose()== EntityPose.STANDING ? Math.min(posDelta * 6.0f,1.0f):0.0f;
        this.limbAnimator.updateLimbs(f,0.2f);
    }


//    Baby Size

    public float getScaleFactor() {
        return 1f;
    }

    public float getScale() {
        AttributeContainer attributeContainer = this.getAttributes();
        return attributeContainer == null ? 2.0F : this.clampScale((float)attributeContainer.getValue(EntityAttributes.GENERIC_SCALE));
    }

    //Breeding

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isIn(ItemTags.LEAVES);
    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.MOOSE.create(world);
    }

    //Attributes

    public static DefaultAttributeContainer.Builder createMooseAttributes()
    {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 35)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.3)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,7)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,2)
                ;
    }

    //Goals

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(1, new AttackGoal(this, 1D, true));
        this.goalSelector.add(1, new MooseEntity.MooseEscapeDangerGoal(this));
        this.goalSelector.add(4, new TemptGoal(this, 1.2, (stack) -> stack.isIn(ItemTags.LEAVES), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.1));
        this.goalSelector.add(6, new WanderAroundFarGoal(this,1.0));
        this.goalSelector.add(7, new TemptGoal(this, 1.2, (stack) -> stack.isIn(ItemTags.LOGS), false));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class,4f));
        this.goalSelector.add(8, new LookAroundGoal(this));

        this.targetSelector.add(1, new MooseEntity.MooseRevengeGoal());
        this.targetSelector.add(2, new MooseEntity.ProtectBabiesGoal());
        this.targetSelector.add(3, new ActiveTargetGoal(this, FoxEntity.class, 10, true, false, null));
        this.targetSelector.add(5, new UniversalAngerGoal(this, false));

    }

    //Goal Variables

    private int angerTime;
    protected float getBaseMovementSpeedMultiplier() {
        return 0.98F;
    }

    private UUID angryAt;

    public boolean isWarning() {return (Boolean)this.dataTracker.get(WARNING);}

    public void setWarning(boolean warning) {
        this.dataTracker.set(WARNING, warning);
    }

    public void setAttacking(boolean attacking) { this.dataTracker.set(ATTACKING, attacking); }

    @Override
    public boolean isAttacking() { return (Boolean)this.dataTracker.get(ATTACKING); }

    private static final TrackedData<Boolean> WARNING = DataTracker.registerData(MooseEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(MooseEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final UniformIntProvider ANGER_TIME_RANGE = TimeHelper.betweenSeconds(20, 39);

    //Custom Goals

    class MooseRevengeGoal extends RevengeGoal {
        public MooseRevengeGoal() {
            super(MooseEntity.this, new Class[0]);
        }

        public void start() {
            super.start();
            if (MooseEntity.this.isBaby())
            {
                this.callSameTypeForRevenge();
                this.stop();
            }
        }

        protected void setMobEntityTarget(MobEntity mob, LivingEntity target) {
            if (mob instanceof MooseEntity && !mob.isBaby()) {
                super.setMobEntityTarget(mob, target);
            }
        }
    }

    /*
    private class AttackGoal extends MeleeAttackGoal {
        public AttackGoal() {
            super(MooseEntity.this, 1.25, true);
        }

        protected void attack(LivingEntity target) {
            if (this.canAttack(target)) {
                this.resetCooldown();
                this.mob.tryAttack(target);
                MooseEntity.this.setWarning(false);
            } else if (this.mob.squaredDistanceTo(target) < (double)((target.getWidth() + 3.0F) * (target.getWidth() + 3.0F))) {
                if (this.isCooledDown()) {
                    MooseEntity.this.setWarning(false);
                    this.resetCooldown();
                }

                if (this.getCooldown() <= 10) {
                    MooseEntity.this.setWarning(true);
                }
            } else {
                this.resetCooldown();
                MooseEntity.this.setWarning(false);
            }

        }

        public void stop() {
            MooseEntity.this.setWarning(false);
            super.stop();
        }
    }
     */

    public class AttackGoal extends MeleeAttackGoal {
        private final MooseEntity entity;
        private int attackDelay = 10;
        private int ticksUntilNextAttack = 10;
        private boolean shouldCountTillNextAttack = false;

        public AttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
            super(mob, speed, pauseWhenMobIdle);
            entity = ((MooseEntity) mob);
        }

        @Override
        public void start() {
            super.start();
            attackDelay = 10;
            ticksUntilNextAttack = 10;
        }

        @Override
        protected void attack(LivingEntity pEnemy) {
            if (isEnemyWithinAttackDistance(pEnemy)) {
                shouldCountTillNextAttack = true;

                if(isTimeToStartAttackAnimation()) {
                    entity.setAttacking(true);
                }

                if(isTimeToAttack()) {
                    this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                    performAttack(pEnemy);
                }
            } else {
                resetAttackCooldown();
                shouldCountTillNextAttack = false;
                entity.setAttacking(false);
                entity.attackAnimationTimeout = 0;
            }
        }

        private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
            return this.entity.distanceTo(pEnemy) <= 2f; // TODO
        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
        }

        protected boolean isTimeToStartAttackAnimation() {
            return this.ticksUntilNextAttack <= attackDelay;
        }

        protected boolean isTimeToAttack() {
            return this.ticksUntilNextAttack <= 0;
        }

        protected void performAttack(LivingEntity pEnemy) {
            this.resetAttackCooldown();
            this.mob.swingHand(Hand.MAIN_HAND);
            this.mob.tryAttack(pEnemy);
        }

        @Override
        public void tick() {
            super.tick();
            if(shouldCountTillNextAttack) {
                this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            }
        }

        @Override
        public void stop() {
            entity.setAttacking(false);
            super.stop();
        }
    }

    class MooseEscapeDangerGoal extends EscapeDangerGoal {
        public MooseEscapeDangerGoal(final MooseEntity moose) {
            super(moose, 2.0);
        }

        protected boolean isInDanger() {
            return this.mob.getAttacker() != null && this.mob.isBaby() || this.mob.isOnFire();
        }
    }

    class ProtectBabiesGoal extends ActiveTargetGoal<PlayerEntity> {
        public ProtectBabiesGoal() {
            super(MooseEntity.this, PlayerEntity.class, 20, true, true, null);
        }

        public boolean canStart() {
            if (MooseEntity.this.isBaby()) {
                return false;
            } else {
                if (super.canStart()) {
                    List<MooseEntity> list = MooseEntity.this.getWorld().getNonSpectatingEntities(MooseEntity.class, MooseEntity.this.getBoundingBox().expand(8.0, 4.0, 8.0));
                    Iterator var2 = list.iterator();

                    while (var2.hasNext()) {
                        MooseEntity mooseEntity = (MooseEntity) var2.next();
                        if (mooseEntity.isBaby()) {
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        protected double getFollowRange() {
            return super.getFollowRange() * 0.5;
        }

    }

    //Important Methods

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(WARNING, false);
        builder.add(ATTACKING, false);
}

    @Override
    public void chooseRandomAngerTime() {this.setAngerTime(ANGER_TIME_RANGE.get(this.random));}

    @Override
    public void setAngerTime(int angerTime) {this.angerTime = angerTime;}

    @Override
    public int getAngerTime() {return this.angerTime;}

    @Override
    public void setAngryAt(@Nullable UUID angryAt) {this.angryAt = angryAt;}

    @Nullable
    @Override
    public UUID getAngryAt() {return this.angryAt;}

    public boolean shouldAngerAt(LivingEntity entity)
    {
        if (!this.canTarget(entity)) {
            return false;
        } else {
            return entity.getType() == EntityType.PLAYER && this.isUniversallyAngry(entity.getWorld()) || entity.getUuid().equals(this.getAngryAt());
        }
    }

    public boolean tryAttack(Entity target) {
        boolean bl = target.damage(this.getDamageSources().mobAttack(this), (float)((int)this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE)));
        if (bl) {

            MooseEntity.this.setAttacking(true);

            this.applyDamageEffects(this, target);
        }

        return bl;
    }

    public Vec3d getLeashOffset()
    {
        return new Vec3d(0.0, (double)(0.6F * this.getStandingEyeHeight()), (double)(this.getWidth() * 0.4F));
    }

    //Sounds

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HORSE_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HORSE_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return this.isBaby() ? SoundEvents.ENTITY_HORSE_HURT : SoundEvents.ENTITY_HORSE_ANGRY;
    }

}
