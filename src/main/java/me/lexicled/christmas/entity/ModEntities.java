package me.lexicled.christmas.entity;

import me.lexicled.christmas.Christmas;
import me.lexicled.christmas.entity.custom.SantaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<SantaEntity> SANTA = Registry.register(Registry.ENTITY_TYPE, new Identifier(Christmas.MOD_ID, "santa"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SantaEntity::new).dimensions(EntityDimensions.fixed(1f, 2.5f)).build()
    );
}
