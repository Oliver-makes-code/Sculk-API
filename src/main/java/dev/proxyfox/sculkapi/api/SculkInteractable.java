package dev.proxyfox.sculkapi.api;

import dev.proxyfox.sculkapi.impl.SculkInteractableImpl;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

/**
 * Interface for blocks that sculk can interact with
 *
 * @author Oliver-makes-code
 * */
public interface SculkInteractable extends SculkInteractableImpl {
	/**
	 * The method called when sculk interacts with an interactable block
	 * @param pos The {@link BlockPos} of the interaction.
	 * @param world The {@link WorldAccess} that the interaction took place in
	 * @param charge The charge level of the block
	 *
	 * @return The amount of charge used
	 *
	 * @author Oliver-makes-code
	 * */
	int onInteract(BlockPos pos, WorldAccess world, int charge);


	/**
	 * Gets the charge amount to feed into the catalyst
	 *
	 * @author Oliver-makes-code
	 * */
	default int getChargeAmount(ServerWorld world, BlockPos pos, BlockState state) {
		return 0;
	}

	/**
	 * Generates a sculk charge
	 *
	 * @author Oliver-makes-code
	 * */
	@Override
	default void generateSculkCharge(WorldAccess world, BlockPos pos) {
		SculkInteractableImpl.super.generateSculkCharge(world, pos);
	}
}
