package com.pogmod.util;

import com.pogmod.PogMod;
import com.pogmod.blocks.BlockItemBase;
import com.pogmod.blocks.TitaniumOreBlock;
import com.pogmod.items.ItemBase;
import com.pogmod.items.TitaniumPickaxe;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PogMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PogMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // here's my items
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", TitaniumPickaxe::new);
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_ORE = ITEMS.register("titanium_ore", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", ItemBase::new);


    // here's my blocks
    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);



    // here's my Blocks as Items
    public static final RegistryObject<Item> TITANIUM_ORE_ITEM = ITEMS.register("titanium_ore_block", () -> new BlockItemBase(TITANIUM_ORE_BLOCK.get()));


}


