package net.extermind.examplemod.item;

import net.minecraft.world.item.Item;

public enum ModItemsEnum {
    // Ordered item list
    MORGANITE(ModItems.MORGANITE.get());

    //  Enum utils
    public final Item item;

    ModItemsEnum(Item item){
        this.item = item;
    }
}
