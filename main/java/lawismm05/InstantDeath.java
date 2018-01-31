package lawismm05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm05.addon.IdAddons;
import lawismm05.handler.IdEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = InstantDeath.MOD_ID, name = InstantDeath.MOD_NAME, version = InstantDeath.MOD_VERSION)

public class InstantDeath {
	public static final String DESCRIPTION = "Lawis Mini Mod #05";
	public static final String MOD_ID = "InstantDeathMod";
	public static final String MOD_NAME = "Instant Death Mod";
	public static final String MOD_VERSION = "1.0";
	public static Logger logger = LogManager.getLogger(MOD_ID);

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		IdInfoCore.registerInfo(meta);

		// イベント処理
		MinecraftForge.EVENT_BUS.register(new IdEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// DQRmodへのアドオン
		IdAddons.loadDQR();
	}
}