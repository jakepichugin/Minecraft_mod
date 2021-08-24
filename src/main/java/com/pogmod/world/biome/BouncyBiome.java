package com.pogmod.world.biome;

import com.pogmod.util.RegistryHandler;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

public class BouncyBiome  {

    public static Biome makeBouncyBiome(){

        final MobSpawnInfo.Builder mobSpawnIB = new MobSpawnInfo.Builder();
        DefaultBiomeFeatures.commonSpawns(mobSpawnIB);

        final BiomeGenerationSettings.Builder biomeGenBuilder = new BiomeGenerationSettings.Builder().surfaceBuilder(
                SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderConfig(
                        RegistryHandler.BOUNCY_BLOCK.get().defaultBlockState(),
                        Blocks.DIRT.defaultBlockState(),
                        Blocks.SLIME_BLOCK.defaultBlockState()))
        );

        DefaultBiomeFeatures.addDefaultOres(biomeGenBuilder);
        DefaultBiomeFeatures.addFossilDecoration(biomeGenBuilder);

        return new Biome.Builder()
                .precipitation(Biome.RainType.NONE)
                .temperature(0.9F)
                .downfall(0)
                .biomeCategory(Biome.Category.PLAINS)
                .depth(0.4F)
                .scale(0.5F)
                .specialEffects(
                        new BiomeAmbience.Builder()
                                .waterColor(0xc90579)
                                .waterFogColor(0xc90579)
                                .fogColor(0xc90579)
                                .skyColor(0xc90579)
                                .ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS)
                                .build())
                .generationSettings(biomeGenBuilder.build())
                .mobSpawnSettings(mobSpawnIB.build())
                .build();
    }

}
