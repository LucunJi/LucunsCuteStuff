package io.github.lucunji.ccshark;

import io.github.lucunji.ccshark.blocks.SandSharkBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ccshark")
public class CCShark {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "ccshark";

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Block> SAND_SHARK_BLOCK = BLOCKS.register("sand_shark", () -> new SandSharkBlock(AbstractBlock.Properties.create(Material.CAKE).hardnessAndResistance(0.5f).sound(SoundType.SLIME)));
    public static final RegistryObject<Item> SAND_SHARK_ITEM = ITEMS.register("sand_shark", () -> new BlockItem(SAND_SHARK_BLOCK.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

    public CCShark() {
        MinecraftForge.EVENT_BUS.register(this);
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) { }

}
