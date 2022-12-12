package me.lexicled.christmas.block.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.context.CommandContextBuilder;
import me.lexicled.christmas.Christmas;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.CommandOutput;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.dimension.AreaHelper;
import org.jetbrains.annotations.Nullable;

public class ChristmasPortalBlock extends HorizontalFacingBlock {
    public ChristmasPortalBlock(Settings settings) {
        super(settings);
    }
    public static final EnumProperty<Direction.Axis> AXIS;
    protected static final VoxelShape X_SHAPE;
    protected static final VoxelShape Z_SHAPE;
    public static final RegistryKey<World> CHRISTMAS;

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction.Axis)state.get(AXIS)) {
            case Z:
                return Z_SHAPE;
            case X:
            default:
                return X_SHAPE;
        }
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        Direction.Axis axis = direction.getAxis();
        Direction.Axis axis2 = (Direction.Axis)state.get(AXIS);
        boolean bl = axis2 != axis && axis.isHorizontal();
        return !bl && !neighborState.isOf(this) && !(new AreaHelper(world, pos, axis2)).wasAlreadyValid() ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0) {
            world.playSound((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
            double d = (double)pos.getX() + random.nextDouble();
            double e = (double)pos.getY() + random.nextDouble();
            double f = (double)pos.getZ() + random.nextDouble();
            double g = ((double)random.nextFloat() - 0.5) * 0.5;
            double h = ((double)random.nextFloat() - 0.5) * 0.5;
            double j = ((double)random.nextFloat() - 0.5) * 0.5;
            int k = random.nextInt(2) * 2 - 1;
            if (!world.getBlockState(pos.west()).isOf(this) && !world.getBlockState(pos.east()).isOf(this)) {
                d = (double)pos.getX() + 0.5 + 0.25 * (double)k;
                g = (double)(random.nextFloat() * 2.0F * (float)k);
            } else {
                f = (double)pos.getZ() + 0.5 + 0.25 * (double)k;
                j = (double)(random.nextFloat() * 2.0F * (float)k);
            }

            world.addParticle(ParticleTypes.PORTAL, d, e, f, g, h, j);
        }

    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis)state.get(AXIS)) {
                    case Z:
                        return (BlockState)state.with(AXIS, Direction.Axis.X);
                    case X:
                        return (BlockState)state.with(AXIS, Direction.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }


    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world instanceof ServerWorld && !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals()) {
            if (world.equals(World.OVERWORLD) || world.equals(World.NETHER) || world.equals(World.END) || entity.isPlayer()) {
                CommandManager cmdmgr = entity.getServer().getCommandManager();
                cmdmgr.execute(cmdmgr.getDispatcher().parse("execute in christmas:christmas/christmas run setblock ~ ~ ~ christmas:christmas_portal", new ServerCommandSource(CommandOutput.DUMMY, entity.getPos(), entity.getRotationClient(), entity.getServer().getOverworld(), 1, entity.getEntityName(), Text.literal(entity.getEntityName()), entity.getServer(), entity)), "execute in christmas:christmas/christmas run setblock ~ ~ ~ christmas:christmas_portal");
                cmdmgr.execute(cmdmgr.getDispatcher().parse("execute in christmas:christmas/christmas run tp @s ~1 ~ ~", new ServerCommandSource(CommandOutput.DUMMY, entity.getPos(), entity.getRotationClient(), entity.getServer().getOverworld(), 1, entity.getEntityName(), Text.literal(entity.getEntityName()), entity.getServer(), entity)), "execute in christmas:christmas/christmas run tp @s ~1 ~ ~");
            }
            else {
                CommandManager cmdmgr = entity.getServer().getCommandManager();
                cmdmgr.execute(cmdmgr.getDispatcher().parse("execute in minecraft:overworld run setblock ~ ~ ~ christmas:christmas_portal", new ServerCommandSource(CommandOutput.DUMMY, entity.getPos(), entity.getRotationClient(), entity.getServer().getOverworld(), 1, entity.getEntityName(), Text.literal(entity.getEntityName()), entity.getServer(), entity)), "execute in minecraft:overworld run setblock ~ ~ ~ christmas:christmas_portal");
                cmdmgr.execute(cmdmgr.getDispatcher().parse("execute in minecraft:overworld run tp @s ~1 ~ ~", new ServerCommandSource(CommandOutput.DUMMY, entity.getPos(), entity.getRotationClient(), entity.getServer().getOverworld(), 1, entity.getEntityName(), Text.literal(entity.getEntityName()), entity.getServer(), entity)), "execute in minecraft:overworld run tp @s ~1 ~ ~");
            }

        }

    }

    static {
        CHRISTMAS = RegistryKey.of(Registry.WORLD_KEY, new Identifier(Christmas.MOD_ID, "christmas/christmas"));
        AXIS = Properties.HORIZONTAL_AXIS;
        X_SHAPE = Block.createCuboidShape(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
        Z_SHAPE = Block.createCuboidShape(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);
    }
}
