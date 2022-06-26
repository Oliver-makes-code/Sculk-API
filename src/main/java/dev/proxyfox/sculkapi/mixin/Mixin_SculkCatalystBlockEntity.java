package dev.proxyfox.sculkapi.mixin;

import dev.proxyfox.sculkapi.api.SculkInteractable;
import dev.proxyfox.sculkapi.impl.ApiInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.SculkCatalystBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SculkCatalystBlockEntity;
import net.minecraft.block.sculk.SculkBehavior;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SculkCatalystBlockEntity.class)
public class Mixin_SculkCatalystBlockEntity extends BlockEntity {
	@Shadow
	@Final
	private SculkBehavior behavior;

	public Mixin_SculkCatalystBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
		super(blockEntityType, blockPos, blockState);
	}

	@Inject(at = @At("RETURN"), method = "listen")
	private void listenForChargeGeneration(ServerWorld world, GameEvent.Message eventMessage, CallbackInfoReturnable<Boolean> cir) {
		if (isRemoved()) return;
		if (eventMessage.getEvent() != ApiInitializer.SCULK_GENERATE) return;
		var pos = new BlockPos(eventMessage.getSourcePos());
		var state = world.getBlockState(pos);
		if (!(state.getBlock() instanceof SculkInteractable interactable)) return;
		int charge = interactable.getChargeAmount(world, pos, state);
		if (charge <= 0) return;
		behavior.addCharge(pos, charge);
		SculkCatalystBlock.bloom(world, getPos(), getCachedState(), world.getRandom());
	}
}
