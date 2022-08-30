package com.github.ZombifiedPatato.extra_origin_powers.effect;

import com.github.ZombifiedPatato.extra_origin_powers.Main;
import com.github.ZombifiedPatato.extra_origin_powers.effect.custom.LightningEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static final StatusEffect LIGHTNING = Registry.register(Registry.STATUS_EFFECT, new Identifier(Main.MOD_ID, "lightning"),
            new LightningEffect(StatusEffectCategory.HARMFUL, 3335601));

    public static void registerEffects() {
        System.out.println("Registering StatusEffects for " + Main.MOD_ID);
    }
}
