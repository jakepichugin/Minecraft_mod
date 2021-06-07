package com.PogMod.items;

import com.PogMod.PogMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {


    public ItemBase() {
//        super(new Item.Properties().tab(ItemGroup.TAB_TOOLS));
        super(new Item.Properties().tab(PogMod.MYMOD_GROUP));
    }
}
