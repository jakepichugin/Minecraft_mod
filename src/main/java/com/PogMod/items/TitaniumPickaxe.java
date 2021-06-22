package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;

public class TitaniumPickaxe extends PickaxeItem {
    public TitaniumPickaxe() {
        super(ModTier.TITANIUM,2, 1.0F, new Item.Properties().tab(PogMod.MYMOD_GROUP));
    }
}
