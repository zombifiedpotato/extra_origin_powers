package com.github.zombifiedpotato.extra_origin_powers.origins.power.custom;

import com.github.zombifiedpotato.extra_origin_powers.Main;
import com.github.zombifiedpotato.extra_origin_powers.interfaces.CraftingScreenHandlerInterface;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModCraftingBlocker extends Power {
    private final Set<String> modids = new HashSet<>();

    public ModCraftingBlocker(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }

    public void addModId (String modid) {
        modids.add(modid);
    }

    public Set<String> getModids() {
        return Set.copyOf(modids);
    }

    public boolean isCraftable (String namespace) {
        return modids.contains(namespace);
    }

    public static PowerFactory<Power> createFactory() {
        return new PowerFactory<>(new Identifier(Main.MOD_ID, "mod_crafting_blocker"),
                new SerializableData()
                        .add("modids", SerializableDataTypes.STRINGS, null)
                        .add("modid", SerializableDataTypes.STRING, null),
                data ->
                        (type, player) -> {
                            ModCraftingBlocker power = new ModCraftingBlocker(type, player);
                            if (data.isPresent("modid")) {
                                power.addModId(data.getString("modid"));
                            }
                            if (data.isPresent("modids")) {
                                for (String modid : ((List<String>)data.get("modids"))) {
                                    power.addModId(modid);
                                }
                            }
                            CraftingScreenHandlerInterface.addModids(power.getModids());
                            return power;
                        });
    }
}
