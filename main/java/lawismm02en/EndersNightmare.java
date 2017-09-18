package lawismm02en;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm02en.config.EnConfigCore;
import lawismm02en.config.EnConfigEventHandler;
import lawismm02en.config.EnInfoCore;
import lawismm02en.event.EnEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = EndersNightmare.MOD_ID, name = EndersNightmare.MOD_NAME, version = EndersNightmare.MOD_VERSION, guiFactory = "lawismm02en.config.EnGuiFactory")

public class EndersNightmare {
	public static final String MOD_ID = "EndersNightmare";
	public static final String MOD_NAME = "Enders' Nightmare";
	public static final String MOD_VERSION = "1.1";
	public static Logger logger = LogManager.getLogger("EndersNightmare");

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		EnInfoCore.registerInfo(meta);
		// コンフィグの読み込み
		EnConfigCore.loadConfig(event);
		// イベント処理
		MinecraftForge.EVENT_BUS.register(new EnEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		// ゲーム内コンフィグ変更の反映
		FMLCommonHandler.instance().bus().register(new EnConfigEventHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}