package me.lexicled.christmas.entity.client;

import me.lexicled.christmas.Christmas;
import me.lexicled.christmas.entity.custom.SantaEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SantaModel extends AnimatedGeoModel<SantaEntity> {
    @Override
    public Identifier getModelResource(SantaEntity object) {
        return new Identifier(Christmas.MOD_ID, "geo/santa.geo.json");
    }

    @Override
    public Identifier getTextureResource(SantaEntity object) {
        return new Identifier(Christmas.MOD_ID, "textures/entity/santa.png");
    }

    @Override
    public Identifier getAnimationResource(SantaEntity animatable) {
        return new Identifier(Christmas.MOD_ID, "animations/santa.animation.json");
    }
}
