package com.pogmod.items;

import com.pogmod.PogMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class TitaniumHelmet extends ArmorItem {
    public TitaniumHelmet() {
        super(ModArmorMaterial.TITANIUM, EquipmentSlotType.HEAD, (new Item.Properties()).tab(PogMod.MYMOD_GROUP));
    }
}
