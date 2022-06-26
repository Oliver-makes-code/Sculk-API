package dev.proxyfox.sculkapi.impl;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.event.GameEvent;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class ApiInitializer implements ModInitializer {
	public static GameEvent SCULK_GENERATE = new GameEvent("sculkapi:sculk_generate", 8);

	@Override
	public void onInitialize(ModContainer mod) {
		Registry.register(Registry.GAME_EVENT, new Identifier("sculkapi", "sculk_generate"), SCULK_GENERATE);
	}
}
