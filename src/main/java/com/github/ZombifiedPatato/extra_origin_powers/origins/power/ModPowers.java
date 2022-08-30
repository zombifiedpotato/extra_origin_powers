package com.github.ZombifiedPatato.extra_origin_powers.origins.power;

import com.github.ZombifiedPatato.extra_origin_powers.origins.power.custom.BreathWeapon;
import com.github.ZombifiedPatato.extra_origin_powers.origins.power.custom.CircleAttack;
import com.github.ZombifiedPatato.extra_origin_powers.origins.power.custom.ModCraftingBlocker;
import com.github.ZombifiedPatato.extra_origin_powers.origins.power.custom.TrinketStarterEquipment;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.util.registry.Registry;

public class ModPowers {
    public static final PowerFactory<Power> TRINKET_STARTER_EQUIPMENT = TrinketStarterEquipment.createFactory();
    public static final PowerFactory<Power> MOD_CRAFTING_BLOCKER = ModCraftingBlocker.createFactory();
    public static final PowerFactory<Power> BREATH_WEAPON = BreathWeapon.createFactory();

    public static final PowerFactory<Power> ATTACK_CIRCLE = CircleAttack.createFactory();

    public static void registerPowers() {
        Registry.register(ApoliRegistries.POWER_FACTORY, TRINKET_STARTER_EQUIPMENT.getSerializerId(), TRINKET_STARTER_EQUIPMENT);
        Registry.register(ApoliRegistries.POWER_FACTORY, MOD_CRAFTING_BLOCKER.getSerializerId(), MOD_CRAFTING_BLOCKER);
        Registry.register(ApoliRegistries.POWER_FACTORY, BREATH_WEAPON.getSerializerId(), BREATH_WEAPON);
        Registry.register(ApoliRegistries.POWER_FACTORY, ATTACK_CIRCLE.getSerializerId(), ATTACK_CIRCLE);
    }
}
