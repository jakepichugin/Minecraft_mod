package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

public class TitaniumHoe extends HoeItem {
    public TitaniumHoe(){
        super(ModTier.TITANIUM,0, 2.0F, new Item.Properties().tab(PogMod.MYMOD_GROUP));

    }
}
