package net.extermind.examplemod.other;

import net.extermind.examplemod.ExampleMod;
import net.extermind.examplemod.item.ModItems;
import net.extermind.examplemod.item.ModItemsEnum;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExampleMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_MOD = CREATIVE_MODE_TABS.register("example_mod",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MORGANITE.get()))
                    .title(Component.translatable("creativetab.example_mod"))
                    .displayItems((pParameters, pOutput) -> {
                        registerAllItems(pOutput);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    private static void registerAllItems(CreativeModeTab.Output pOutput) {
        Arrays.stream(ModItemsEnum.values())
                .forEach(enumValue -> {
                    pOutput.accept(enumValue.item);
                });
    }
}
