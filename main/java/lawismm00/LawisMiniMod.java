package lawismm00;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LawisMiniMod.MOD_ID, name = LawisMiniMod.MOD_NAME, version = LawisMiniMod.MOD_VERSION)

public class LawisMiniMod {
	public static final String DESCRIPTION = "Lawis Mini Mod #00";
	public static final String MOD_ID = "ID";
	public static final String MOD_NAME = "NAME";
	public static final String MOD_VERSION = "1.0";
	public static Logger logger = LogManager.getLogger(MOD_ID);

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		InfoCore.registerInfo(meta);
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}