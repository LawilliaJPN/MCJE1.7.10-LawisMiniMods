package lawismm04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm04.addon.PpAddons;
import lawismm04.event.PpEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = PowerlessPlayer.MOD_ID, name = PowerlessPlayer.MOD_NAME, version = PowerlessPlayer.MOD_VERSION)

public class PowerlessPlayer {
	public static final String DESCRIPTION = "Lawis Mini Mod #04";
	public static final String MOD_ID = "PowerlessPlayerMod";
	public static final String MOD_NAME = "Powerless Player Mod";
	public static final String MOD_VERSION = "1.1";
	public static Logger logger = LogManager.getLogger(MOD_ID);

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		PpInfoCore.registerInfo(meta);
		// イベント処理
		MinecraftForge.EVENT_BUS.register(new PpEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// アドオン
		PpAddons.loadMods();
	}
}