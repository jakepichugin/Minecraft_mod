package com.pogmod;

import com.pogmod.entity.PenguinEntity;
import com.pogmod.entity.render.PenguinRenderer;
import com.pogmod.util.RegistryHandler;
import com.pogmod.world.gen.OreGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("pogmod")
public class PogMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "pogmod";
    public static final ItemGroup MYMOD_GROUP = new PogTab("pogtab");

    public PogMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        //register ores
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGenerator::generateOres);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        DeferredWorkQueue.runLater(()->{
            GlobalEntityTypeAttributes.put(RegistryHandler.PENGUIN_ENTITY.get(), PenguinEntity.setCustomAttributes());
        });

        event.enqueueWork(()-> {
            setupBiome(RegistryHandler.BOUNCY_BIOME.get(), BiomeManager.BiomeType.WARM, 1000, BiomeDictionary.Type.OVERWORLD);
        });



        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private static RegistryKey<Biome> key(final Biome biome){
        return RegistryKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome), "Biome Registry was null"));
    }

    public static void setupBiome(final Biome biome, final BiomeManager.BiomeType biomeType, final int weight, final BiomeDictionary.Type... types){
        BiomeDictionary.addTypes(key(biome), types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(key(biome), weight));

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client

        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.BOMB_ENTITY.get(),
                renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.PENGUIN_EGG_ENTITY.get(),
                renderManager -> new SpriteRenderer<>(renderManager, Minecraft.getInstance().getItemRenderer()));

        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.PENGUIN_ENTITY.get(), PenguinRenderer::new);

        LOGGER.debug("Registered entity Renderers");

        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    //--------------------------------------------------------------------------------------------------------------------- Custom Tabs
    public static class PogTab extends ItemGroup {

        public PogTab(String label){super(label); }

        @Override
        public ItemStack makeIcon() { return RegistryHandler.TITANIUM_PICKAXE.get().getDefaultInstance();}

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
