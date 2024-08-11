package net.Mrtemur.VanillaMore.villager;

import com.google.common.collect.ImmutableSet;
import net.Mrtemur.VanillaMore.block.Modblocks;
import net.Mrtemur.VanillaMore.vanillamore;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.concurrent.Immutable;

public class ModVillager {
    public static  final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, vanillamore.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, vanillamore.MOD_ID);

    public static final RegistryObject<PoiType> SOUND_POI = POI_TYPES.register("sound_poi",
            () -> new PoiType(ImmutableSet.copyOf(Modblocks.GRILL_BLOCK.get().getStateDefinition().getPossibleStates()),
                   1,1 ));
    public static final RegistryObject<VillagerProfession>  GRILLER_CHEF =
            VILLAGER_PROFESSIONS.register("grillchef", () -> new VillagerProfession("grillchef",
                    holder -> holder.get() == SOUND_POI.get(), holder -> holder.get() == SOUND_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_BUTCHER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
