package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class TitaniumChestplate extends ArmorItem {
    public TitaniumChestplate() {
        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.CHEST, (new Item.Properties()).tab(PogMod.MYMOD_GROUP));
    }
}
