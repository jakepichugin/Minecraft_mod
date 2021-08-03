package com.pogmod.util;

import com.pogmod.PogMod;
import com.pogmod.blocks.BlockItemBase;
import com.pogmod.blocks.TitaniumOreBlock;
import com.pogmod.entity.BombEntity;
import com.pogmod.entity.PenguinEntity;
import com.pogmod.items.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PogMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PogMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, PogMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // here's my items
    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe", TitaniumPickaxe::new);
    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe", TitaniumAxe::new);
    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe", TitaniumHoe::new);
    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel", TitaniumShovel::new);
    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword", TitaniumSword::new);
    public static final RegistryObject<Item> TITANIUM_ORE = ITEMS.register("titanium_ore", ItemBase::new);
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", ItemBase::new);

    // here's my bomb
    public static final RegistryObject<Item> BOMB = ITEMS.register("bomb", Bomb::new);


    // here's my armor
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet", TitaniumHelmet::new);
    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate", TitaniumChestplate::new);
    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings", TitaniumLeggings::new);
    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots", TitaniumBoots::new);




    // here's my blocks
    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = BLOCKS.register("titanium_ore_block", TitaniumOreBlock::new);



    // here's my Blocks as Items
    public static final RegistryObject<Item> TITANIUM_ORE_ITEM = ITEMS.register("titanium_ore_block", () -> new BlockItemBase(TITANIUM_ORE_BLOCK.get()));




    // NOT FINISHED IDK IF IT WILL RUN BUT HERE GOES OUR ENTITIES!
    //Entities
    public static final RegistryObject<EntityType<BombEntity>> BOMB_ENTITY = ENTITIES.register("bomb",
            () -> EntityType.Builder.<BombEntity>of(BombEntity::new, EntityClassification.MISC)
                    .sized(0.5f, 0.5f)
                    .build("bomb"));
    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN_ENTITY = ENTITIES.register("penguin",
            () -> EntityType.Builder.<PenguinEntity>of(PenguinEntity::new, EntityClassification.CREATURE)
                    .sized(1F, 1F)
                    .build("penguin"));




}

