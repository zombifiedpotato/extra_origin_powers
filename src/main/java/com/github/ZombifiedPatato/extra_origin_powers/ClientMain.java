package com.github.ZombifiedPatato.extra_origin_powers;

import com.github.ZombifiedPatato.extra_origin_powers.particle.ModParticles;
import com.github.ZombifiedPatato.extra_origin_powers.particle.custom.DragonBreathParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

@Environment(EnvType.CLIENT)
public class ClientMain implements ClientModInitializer {

    @Override
    public void onInitializeClient(){
        Main.LOGGER.info("Client initialization for " + Main.MOD_ID + "!");
        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_DRAGON_BREATH, DragonBreathParticle.RedFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.GREEN_DRAGON_BREATH, DragonBreathParticle.GreenFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLUE_DRAGON_BREATH, DragonBreathParticle.BlueFactory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BLACK_DRAGON_BREATH, DragonBreathParticle.BlackFactory::new);
    }
}
