package com.pogmod.models;
// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.pogmod.entity.PenguinEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PenguinModel<T extends PenguinEntity> extends EntityModel<T> {

	private final ModelRenderer main;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer beak;
	private final ModelRenderer leftarm;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;

	public PenguinModel() {
		texWidth = 64;
		texHeight = 32;

		main = new ModelRenderer(this);
		main.setPos(0.0F, 24.0F, 0.0F);


		body = new ModelRenderer(this);
		body.setPos(0.0F, 0.0F, 0.0F);
		main.addChild(body);
		body.texOffs(0, 16).addBox(-4.0F, -10.0F, -2.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, 0.0F, 0.0F);
		main.addChild(head);
		head.texOffs(0, 0).addBox(-4.0F, -18.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		beak = new ModelRenderer(this);
		beak.setPos(0.0F, 0.0F, 0.0F);
		head.addChild(beak);
		beak.texOffs(32, 8).addBox(-1.0F, -13.0F, -5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setPos(0.0F, 0.0F, 0.0F);
		main.addChild(leftarm);
		leftarm.texOffs(24, 16).addBox(4.0F, -10.0F, -2.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setPos(0.0F, 0.0F, 0.0F);
		main.addChild(rightarm);
		rightarm.texOffs(24, 16).addBox(-5.0F, -10.0F, -2.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setPos(0.0F, 0.0F, 0.0F);
		main.addChild(leftleg);
		leftleg.texOffs(32, 0).addBox(1.0F, -2.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setPos(0.0F, 0.0F, 0.0F);
		main.addChild(rightleg);
		rightleg.texOffs(32, 0).addBox(-4.0F, -2.0F, -4.0F, 3.0F, 2.0F, 6.0F, 0.0F, false);
	}

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		leftarm.xRot = MathHelper.cos(ageInTicks * 0.6662F) * 1.4F  * limbSwingAmount;
		leftarm.yRot = 0.0F;
		rightarm.xRot = MathHelper.cos(ageInTicks * 0.6662F + 3.141593F)  * 1.4F * limbSwingAmount;
		rightarm.yRot = 0.0F;
		leftleg.xRot = MathHelper.cos(ageInTicks)  * 1.4F * limbSwingAmount * 0.5F;
		leftleg.yRot = 0.0F;
		rightleg.xRot = MathHelper.cos(ageInTicks + 3.141593F) * 1.4F * limbSwingAmount * 0.5F;
		rightleg.yRot = 0.0F;
    }


	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}


    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}