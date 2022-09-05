package com.github.ZombifiedPatato.extra_origin_powers.item;

import com.github.ZombifiedPatato.extra_origin_powers.Main;
import com.github.ZombifiedPatato.extra_origin_powers.item.custom.PotatoCrownItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item POTATO_CROWN_ITEM = new PotatoCrownItem(new FabricItemSettings().group(ItemGroup.COMBAT));

    public static void registerItems () {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "potato_crown"), POTATO_CROWN_ITEM);
    }
}
