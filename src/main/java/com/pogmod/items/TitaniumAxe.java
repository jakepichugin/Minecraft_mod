package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;

public class TitaniumAxe extends AxeItem {
    public TitaniumAxe(){
        super(ModTier.TITANIUM,3, 1.0F, new Item.Properties().tab(PogMod.MYMOD_GROUP));
    }
}
