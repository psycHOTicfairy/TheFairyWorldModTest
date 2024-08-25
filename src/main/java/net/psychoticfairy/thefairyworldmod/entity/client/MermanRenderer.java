package net.psychoticfairy.thefairyworldmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.psychoticfairy.thefairyworldmod.TheFairyWorldMod;
import net.psychoticfairy.thefairyworldmod.entity.custom.MermanEntity;
import org.jetbrains.annotations.Nullable;

public class MermanRenderer extends MobRenderer<MermanEntity, MermanModel<MermanEntity>> {

    public MermanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new MermanModel<>(pContext.bakeLayer(ModModelLayers.MERMAN_LAYER)), 2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MermanEntity pEntity) {
        return new ResourceLocation(TheFairyWorldMod.MOD_ID, "textures/entity/merman.png");
    }

    @Override
    public void render(MermanEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}

