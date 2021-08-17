package com.pogmod.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MoodSoundAmbience;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

public class BouncyBiome extends Biome {
    protected BouncyBiome(){
        super(new Biome.Builder()
                .precipitation(RainType.NONE)
                .temperature(0.9F)
                .temperatureAdjustment(TemperatureModifier.NONE)
                .downfall(0)
                .biomeCategory(Category.NONE)
                .depth(0.7F)
                .scale(1.7F)
                .specialEffects(new BiomeAmbience.Builder().ambientMoodSound(MoodSoundAmbience.LEGACY_CAVE_SETTINGS).build())
                .generationSettings(BiomeGenerationSettings.Builder())
                .mobSpawnSettings());
    }

}
