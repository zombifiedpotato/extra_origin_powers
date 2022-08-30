package com.github.ZombifiedPatato.extra_origin_powers.origins.power.custom;

import com.github.ZombifiedPatato.extra_origin_powers.Main;
import dev.emi.trinkets.api.TrinketItem;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;

import java.util.LinkedList;
import java.util.List;

public class TrinketStarterEquipment extends Power {
    private final List<ItemStack> items = new LinkedList<>();
    private boolean recurrent;

    public TrinketStarterEquipment(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }

    public void addStack(ItemStack item){
        items.add(item);
    }

    private void giveStacks() {
        System.out.println("items before giving: " + items);
        for (ItemStack item : items) {
            if (entity instanceof PlayerEntity player) {
                if(!TrinketItem.equipItem(player, item.copy())) {
                    if(!player.giveItemStack(item.copy())){
                        player.dropStack(item.copy());
                    }
                }
            }else {
                entity.dropStack(item.copy());
            }
        }
        System.out.println("items after giving: " + items);
    }

    @Override
    public void onGained() {
        giveStacks();
    }

    @Override
    public void onRespawn() {
        System.out.println("respawn commencing recurrent is set to " + recurrent);
        if (recurrent){
            giveStacks();
        }
    }

    public static PowerFactory<Power> createFactory() {
        return new PowerFactory<>(new Identifier(Main.MOD_ID, "starting_equipment"),
                new SerializableData()
                        .add("stack", ApoliDataTypes.POSITIONED_ITEM_STACK, null)
                        .add("stacks", ApoliDataTypes.POSITIONED_ITEM_STACKS, null)
                        .add("recurrent", SerializableDataTypes.BOOLEAN, false),
                data ->
                        (type, player) -> {
                            TrinketStarterEquipment power = new TrinketStarterEquipment(type, player);
                            if (data.isPresent("stack")) {
                                Pair<Integer, ItemStack> itemStackPair = data.get("stack");
                                power.addStack(itemStackPair.getRight());
                            }
                            if (data.isPresent("stacks")) {
                                ((List<Pair<Integer, ItemStack>>)data.get("stacks")).forEach(integerItemStackPair -> power.addStack(integerItemStackPair.getRight()));
                            }
                            power.setRecurrent(data.getBoolean("recurrent"));
                            return power;
                        }
                );
    }
}
