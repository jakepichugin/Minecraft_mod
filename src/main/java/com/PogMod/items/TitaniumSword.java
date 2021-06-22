package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class TitaniumSword extends SwordItem {
    public TitaniumSword(){
        super(ModTier.TITANIUM,3, 2.0F, new Item.Properties().tab(PogMod.MYMOD_GROUP));

    }
}
