package io.github.lucunji.crispycrispysandshark;

import io.github.lucunji.crispycrispysandshark.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ccshark")
public class CCShark {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "ccshark";

    public CCShark() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) { }

}
