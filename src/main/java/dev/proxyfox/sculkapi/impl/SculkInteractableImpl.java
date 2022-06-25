package dev.proxyfox.sculkapi.impl;

import net.minecraft.block.sculk.SculkBehavior;
import net.minecraft.block.sculk.SculkVeinSpreader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.WorldAccess;

public interface SculkInteractableImpl extends SculkVeinSpreader {
	int onInteract(BlockPos pos, WorldAccess world, int charge);

	@Override
	default int tryUseCharge(
			SculkBehavior.ChargeCursor charge,
			WorldAccess world,
			BlockPos pos,
			RandomGenerator random,
			SculkBehavior sculkChargeHandler,
			boolean spread
	) {
		int i = charge.getCharge();

		return i-onInteract(charge.getPos(), world, i);
	}

	@Override
	default boolean canUpdateOnSpread() {
		return true;
	}
}
