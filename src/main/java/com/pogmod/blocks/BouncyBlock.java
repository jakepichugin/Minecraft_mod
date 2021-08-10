package com.pogmod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BouncyBlock extends Block {
    public BouncyBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .strength(5.0f, 6.0f)
                .sound(SoundType.SHROOMLIGHT)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

}
