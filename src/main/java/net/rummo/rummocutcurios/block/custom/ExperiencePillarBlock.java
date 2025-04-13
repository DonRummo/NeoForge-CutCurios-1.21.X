package net.rummo.rummocutcurios.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ExperiencePillarBlock extends RotatedPillarBlock
{
    private final UniformInt xpRange;

    public ExperiencePillarBlock(UniformInt xpRange, Properties properties)
    {
        super(properties);
        this.xpRange = xpRange;
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, BlockEntity be, ItemStack stack)
    {
        super.playerDestroy(level, player, pos, state, be, stack);

        if (!level.isClientSide && !stack.isEmpty() && stack.isCorrectToolForDrops(state))
        {
            int xp = xpRange.sample(level.random);
            if (xp > 0) {
                this.popExperience((ServerLevel) level, pos, xp);
            }
        }
    }
}

