package com.pogmod.entity;

import com.pogmod.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.client.gui.widget.ModListWidget;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class PenguinEntity extends AnimalEntity {

    public static final Ingredient TEMP_INGREDIENT = Ingredient.of(Items.COD, Items.SALMON, Items.COD_BUCKET, Items.SALMON_BUCKET, Items.COOKED_COD, Items.COOKED_SALMON);
    public PenguinEntity(final World worldIn) { super(RegistryHandler.PENGUIN_ENTITY.get(), worldIn); }

    public PenguinEntity(final EntityType<? extends AnimalEntity> type, final World worldIn) { super(type, worldIn); }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, TEMP_INGREDIENT, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap setCustomAttributes(){
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 16.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.20D)
                .add(Attributes.FOLLOW_RANGE, 10.0D)
                .build();
    }


    public PenguinEntity createChild(final AgeableEntity parent) {
        return RegistryHandler.PENGUIN_ENTITY.get().create(this.level);

    }


    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    static class GoToWaterGoal extends MoveToBlockGoal {
        private final PenguinEntity penguin;

        private GoToWaterGoal(PenguinEntity p_i48819_1_, double p_i48819_2_) {
            super(p_i48819_1_, p_i48819_1_.isBaby() ? 2.0D : p_i48819_2_, 24);
            this.penguin = p_i48819_1_;
            this.verticalSearchStart = -1;
        }

        public boolean canContinueToUse() {
            return !this.penguin.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.penguin.level, this.blockPos);
        }

        public boolean canUse() {
            if (this.penguin.isBaby() && !this.penguin.isInWater()) {
                return super.canUse();
            } else {
                return !this.penguin.isInWater() ? super.canUse() : false;
            }
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 160 == 0;
        }

        protected boolean isValidTarget(IWorldReader p_179488_1_, BlockPos p_179488_2_) {
            return p_179488_1_.getBlockState(p_179488_2_).is(Blocks.WATER);
        }
    }


}