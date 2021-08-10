package com.pogmod.entity;

import com.pogmod.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class PenguinEggEntity extends ProjectileItemEntity {
    public PenguinEggEntity(EntityType<? extends ProjectileItemEntity> p_i50154_1_, World p_i50154_2_) {
        super(p_i50154_1_, p_i50154_2_);
    }

    public PenguinEggEntity(World p_i1780_1_, LivingEntity p_i1780_2_) {
        super(RegistryHandler.PENGUIN_EGG_ENTITY.get(), p_i1780_2_, p_i1780_1_);
    }

    public PenguinEggEntity(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_) {
        super(RegistryHandler.PENGUIN_EGG_ENTITY.get(), p_i1781_2_, p_i1781_4_, p_i1781_6_, p_i1781_1_);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleData(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        p_213868_1_.getEntity().hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                        PenguinEntity penguinEntity = RegistryHandler.PENGUIN_ENTITY.get().create(this.level);
                    penguinEntity.setAge(-24000);
                    penguinEntity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
                    this.level.addFreshEntity(penguinEntity);
                }
            }

            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }

    }

    protected Item getDefaultItem() {
        return RegistryHandler.PENGUIN_EGG.get();
    }

    @Override
    public IPacket<?> getAddEntityPacket(){return NetworkHooks.getEntitySpawningPacket(this);
    }
}
