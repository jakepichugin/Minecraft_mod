package com.pogmod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BouncyBlock extends Block {
    public BouncyBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .strength(0.1f, 2f) // first one is blast risestance, second mining speed
                .sound(SoundType.SHROOMLIGHT)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

    @Override
    public void stepOn(World world, BlockPos blockpos, Entity entity) {
        super.stepOn(world, blockpos, entity);

        entity.setDeltaMovement(0.0, 1, 0);






    }

    @Override
    public void fallOn(World world, BlockPos blockpos, Entity entity, float falldist) {

        if(entity.isSuppressingBounce()) {
            super.fallOn(world, blockpos, entity, falldist);
        }
        else{
            entity.causeFallDamage(falldist, 0.0F);
        }
    }





}
