package me.lexicled.christmas.entity.client;

import me.lexicled.christmas.Christmas;
import me.lexicled.christmas.entity.custom.SantaEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SantaRenderer extends GeoEntityRenderer<SantaEntity> {
    public SantaRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new SantaModel());
        this.shadowRadius = 0.7f;
    }

    @Override
    public Identifier getTextureResource(SantaEntity animatable) {
        return new Identifier(Christmas.MOD_ID, "textures/entity/santa.png");
    }

    @Override
    public RenderLayer getRenderType(SantaEntity animatable, float partialTick, MatrixStack poseStack, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, int packedLight, Identifier texture) {
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
