package com.PogMod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraftforge.common.ToolType;

public class TitaniumOreBlock extends Block {

    public TitaniumOreBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .strength(5.0f, 6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }

}
