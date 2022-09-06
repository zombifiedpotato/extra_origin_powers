package com.github.zombifiedpotato.extra_origin_powers;

import com.github.zombifiedpotato.extra_origin_powers.item.ModItems;
import com.github.zombifiedpotato.extra_origin_powers.origins.condition.ModConditions;
import com.github.zombifiedpotato.extra_origin_powers.origins.power.ModPowers;
import com.github.zombifiedpotato.extra_origin_powers.particle.ModParticles;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static String MOD_ID = "extra_origin_powers";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_ID + " is starting! Lets give those origins some powers!");
		ModParticles.registerModParticles();
		ModConditions.registerModConditions();
		ModPowers.registerPowers();
		ModItems.registerItems();
	}
}
