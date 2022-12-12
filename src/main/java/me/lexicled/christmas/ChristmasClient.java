package me.lexicled.christmas;

import me.lexicled.christmas.entity.ModEntities;
import me.lexicled.christmas.entity.client.SantaRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ChristmasClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.SANTA, SantaRenderer::new);
    }
}
