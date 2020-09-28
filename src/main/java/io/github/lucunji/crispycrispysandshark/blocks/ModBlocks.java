package io.github.lucunji.crispycrispysandshark.blocks;

import io.github.lucunji.crispycrispysandshark.CCShark;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final Block SAND_SHARK = new SandSharkBlock(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(0.5f).sound(SoundType.SLIME)).setRegistryName(CCShark.MOD_ID, "sand_shark");

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
        blockRegistryEvent.getRegistry().register(ModBlocks.SAND_SHARK);
    }
}
