package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

public class TitaniumShovel extends ShovelItem {
    public TitaniumShovel(){
        super(ModTier.TITANIUM,0, 2.0F, new Item.Properties().tab(PogMod.MYMOD_GROUP));

    }
}
