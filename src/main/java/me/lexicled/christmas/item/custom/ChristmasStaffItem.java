package me.lexicled.christmas.item.custom;

import me.lexicled.christmas.block.ModBlocks;
import me.lexicled.christmas.entity.ModEntities;
import me.lexicled.christmas.entity.custom.SantaEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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

    private boolean monologueHappen = false;

    public void devilMonologue(PlayerEntity player, World world, Entity santa) throws InterruptedException {
        if (monologueHappen == true) {
            Thread.sleep(4000);
            player.sendMessage(Text.translatable("dialogue.christmas.devil1"));
            Thread.sleep(2000);
            player.sendMessage(Text.translatable("dialogue.christmas.devil2"));
            Thread.sleep(1000);
            santa.kill();
            Thread.sleep(1000);
            player.sendMessage(Text.translatable("dialogue.christmas.devil3"));
            Thread.sleep(5000);
            player.sendMessage(Text.translatable("dialogue.christmas.devil4"));
            monologueHappen = false;
        }
        else {
            monologueHappen = true;
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.CHRISTMAS_TREE)) {
            Entity santa = new SantaEntity(ModEntities.SANTA, world);
            santa.setPosition(new Vec3d(context.getBlockPos().getX(), context.getBlockPos().getY(), context.getBlockPos().getZ()));
            world.spawnEntity(santa);
            try {
                devilMonologue(context.getPlayer(), world, santa);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return super.useOnBlock(context);
    }
}
