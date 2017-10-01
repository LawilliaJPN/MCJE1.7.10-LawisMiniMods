package lawismm03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm03.config.LrdInfoCore;
import lawismm03.event.LrdEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = LogResetForDQRHC.MOD_ID, name = LogResetForDQRHC.MOD_NAME, version = LogResetForDQRHC.MOD_VERSION)

public class LogResetForDQRHC {
	public static final String DESCRIPTION = "Lawis Mini Mod #03";
	public static final String MOD_ID = "LogResetForDQRmodHardCore";
	public static final String MOD_NAME = "Log Reset for DQRmod HardCore";
	public static final String MOD_VERSION = "1.0";
	public static Logger logger = LogManager.getLogger(MOD_ID);

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		LrdInfoCore.registerInfo(meta);
		// イベント
		MinecraftForge.EVENT_BUS.register(new LrdEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}