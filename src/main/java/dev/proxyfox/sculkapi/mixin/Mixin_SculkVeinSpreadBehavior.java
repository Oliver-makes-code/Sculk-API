package dev.proxyfox.sculkapi.mixin;

import dev.proxyfox.sculkapi.api.SculkInteractable;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net/minecraft/block/SculkVeinBlock$SculkVeinSpreadBehavior"})
public class Mixin_SculkVeinSpreadBehavior {
	@Inject(method = "canPlace", at = @At("RETURN"), cancellable = true)
	private void checkInteractable(BlockView view, BlockPos posA, BlockPos posB, Direction dir, BlockState state, CallbackInfoReturnable<Boolean> cir) {
		BlockState blockState = view.getBlockState(posB.offset(dir));
		if (blockState.getBlock() instanceof SculkInteractable)
			cir.setReturnValue(false);
	}
}
