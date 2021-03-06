package ewewukek.musketmod;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

@Mod(MusketMod.MODID)
public class MusketMod {
    public static final String MODID = "musketmod";

    @ObjectHolder(MusketMod.MODID + ":musket")
    public static Item MUSKET;

    public MusketMod() {
        ModLoadingContext.get().registerConfig(net.minecraftforge.fml.config.ModConfig.Type.SERVER, Config.SPEC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID, "barrel"),
                    new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID, "rifled_barrel"),
                    new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(MODID, "stock"),
                    new Item(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "cartridge"),
                    new MusketItem(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "musket"),
                    new RifleItem(new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(MODID, "rifle")
            );
        }

        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().register(
                    EntityType.Builder.<BulletEntity>create(EntityClassification.MISC)
                            .setCustomClientFactory(BulletEntity::new).size(0.5f, 0.5f)
                            .setTrackingRange(64).setUpdateInterval(5).setShouldReceiveVelocityUpdates(false)
                            .build(MODID + ":bullet").setRegistryName(MODID, "bullet")
            );
        }

        @SubscribeEvent
        public static void onSoundRegistry(final RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(
                    new SoundEvent(new ResourceLocation(MODID, "musket_load0")).setRegistryName(MODID, "musket_load0"),
                    new SoundEvent(new ResourceLocation(MODID, "musket_load1")).setRegistryName(MODID, "musket_load1"),
                    new SoundEvent(new ResourceLocation(MODID, "musket_load2")).setRegistryName(MODID, "musket_load2"),
                    new SoundEvent(new ResourceLocation(MODID, "musket_ready")).setRegistryName(MODID, "musket_ready"),
                    new SoundEvent(new ResourceLocation(MODID, "musket_fire")).setRegistryName(MODID, "musket_fire"),
                    new SoundEvent(new ResourceLocation(MODID, "rifle_load0")).setRegistryName(MODID, "rifle_load0"),
                    new SoundEvent(new ResourceLocation(MODID, "rifle_load1")).setRegistryName(MODID, "rifle_load1"),
                    new SoundEvent(new ResourceLocation(MODID, "rifle_load2")).setRegistryName(MODID, "rifle_load2"),
                    new SoundEvent(new ResourceLocation(MODID, "rifle_load3")).setRegistryName(MODID, "rifle_load3"),
                    new SoundEvent(new ResourceLocation(MODID, "rifle_ready")).setRegistryName(MODID, "rifle_ready"),
                    new SoundEvent(new ResourceLocation(MODID, "musket_fire")).setRegistryName(MODID, "rifle_fire")
            );
        }

    }
}
