package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class TitaniumLeggings extends ArmorItem {
    public TitaniumLeggings() {
        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.LEGS, (new Item.Properties()).tab(PogMod.MYMOD_GROUP));
    }
}