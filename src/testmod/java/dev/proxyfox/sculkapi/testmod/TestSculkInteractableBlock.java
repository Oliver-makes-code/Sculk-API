package dev.proxyfox.sculkapi.testmod;

import dev.proxyfox.sculkapi.api.SculkInteractable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.LegacySimpleRandom;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class TestSculkInteractableBlock extends Block implements SculkInteractable {
	RandomGenerator generator = new LegacySimpleRandom(0);

	public TestSculkInteractableBlock(Settings settings) {
		super(settings);
	}

	@Override
	public int onInteract(BlockPos pos, WorldAccess world, int charge) {
		return 0;
	}

	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
		super.neighborUpdate(state, world, pos, block, fromPos, notify);
		if (world.getReceivedRedstonePower(pos) > 0)
			generateSculkCharge(world, pos);
	}

	@Override
	public int getChargeAmount(ServerWorld world, BlockPos pos, BlockState state) {
		return 1;
	}
}
