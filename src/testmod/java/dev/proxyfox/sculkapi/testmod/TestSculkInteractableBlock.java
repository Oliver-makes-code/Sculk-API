package dev.proxyfox.sculkapi.testmod;

import dev.proxyfox.sculkapi.api.SculkInteractable;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.LegacySimpleRandom;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.WorldAccess;

public class TestSculkInteractableBlock extends Block implements SculkInteractable {
	RandomGenerator generator = new LegacySimpleRandom(0);

	public TestSculkInteractableBlock(Settings settings) {
		super(settings);
	}

	@Override
	public int onInteract(BlockPos pos, WorldAccess world, int charge) {
		Direction dir = Direction.random(generator);
		if (!world.getBlockState(pos.offset(dir,2)).isAir())
			return 0;
		world.setBlockState(pos.offset(dir, 2), Blocks.END_STONE.getDefaultState(), 2);
		return 1;
	}
}
