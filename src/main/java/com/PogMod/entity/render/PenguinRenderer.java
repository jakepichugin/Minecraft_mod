package com.pogmod.entity.render;

import com.pogmod.PogMod;
import com.pogmod.entity.PenguinEntity;
import com.pogmod.models.PenguinModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(PogMod.MOD_ID, "textures/entity/penguin.png");


    public PenguinRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new PenguinModel<PenguinEntity>(),0.5F);
    }
}
