package com.pogmod.entity;

import com.pogmod.items.Bomb;
import com.pogmod.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;


public class BombEntity extends ProjectileItemEntity {
    public BombEntity(EntityType<? extends ProjectileItemEntity> type, World p_i50154_2_) {
        super(RegistryHandler.BOMB_ENTITY.get(), p_i50154_2_);
    }

    public BombEntity(World p_i1780_1_, LivingEntity p_i1780_2_) {
        super(RegistryHandler.BOMB_ENTITY.get(), p_i1780_2_, p_i1780_1_);
    }

    public BombEntity(World p_i1781_1_) {
        super(RegistryHandler.BOMB_ENTITY.get(), p_i1781_1_);
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
                    ChickenEntity chickenentity = EntityType.CHICKEN.create(this.level);
                    chickenentity.setAge(-24000);
                    chickenentity.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
                    this.level.addFreshEntity(chickenentity);
                }
            }

            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }
        public IPacket<?> createSpawnPacket(){
            return NetworkHooks.getEntitySpawningPacket(this);
        }

    }

    protected Item getDefaultItem() {
        return RegistryHandler.BOMB.get();
    }



}
