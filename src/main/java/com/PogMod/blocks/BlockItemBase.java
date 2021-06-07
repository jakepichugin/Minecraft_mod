package com.PogMod.blocks;

import com.PogMod.PogMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block){
        super(block, new Properties().tab(PogMod.MYMOD_GROUP));
    }

}
