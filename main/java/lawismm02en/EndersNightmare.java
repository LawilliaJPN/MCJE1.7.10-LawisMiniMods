package lawismm02en;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = EndersNightmare.MOD_ID, name = EndersNightmare.MOD_NAME, version = EndersNightmare.MOD_VERSION)

public class EndersNightmare {
	public static final String MOD_ID = "EndersNightmare";
	public static final String MOD_NAME = "Enders' Nightmare";
	public static final String MOD_VERSION = "1.0";
	public static Logger logger = LogManager.getLogger("EndersNightmare");

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		EnInfoCore.registerInfo(meta);
		// イベント処理
		MinecraftForge.EVENT_BUS.register(new EnEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}