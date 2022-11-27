package me.lexicled.christmas.item.custom;

import me.lexicled.christmas.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ChristmasStaffItem extends Item {
    public ChristmasStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.CHRISTMAS_TREE)) {
            // TODO: Summon Santa
            Entity sheep = new SheepEntity(EntityType.SHEEP, world);
            sheep.setPosition(new Vec3d(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ()));
            world.spawnEntity(sheep);
        }
        return super.useOnBlock(context);
    }
}
