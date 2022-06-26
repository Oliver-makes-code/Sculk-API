package dev.proxyfox.sculkapi.testmod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class TestMod implements ModInitializer {
	static Block testInteractableBlock = new TestSculkInteractableBlock(QuiltBlockSettings.copyOf(Blocks.STONE));
	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registry.BLOCK, new Identifier("sculkapi", "testblock"), testInteractableBlock);
	}
}
