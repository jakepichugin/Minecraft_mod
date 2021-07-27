package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class TitaniumBoots extends ArmorItem {
    public TitaniumBoots() {
        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.FEET, (new Item.Properties()).tab(PogMod.MYMOD_GROUP));
    }
}