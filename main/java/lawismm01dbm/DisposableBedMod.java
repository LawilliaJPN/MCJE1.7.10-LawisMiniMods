package lawismm01dbm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm01dbm.config.DbmInfoCore;
import lawismm01dbm.event.DbmEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = DisposableBedMod.MOD_ID, name = DisposableBedMod.MOD_NAME, version = DisposableBedMod.MOD_VERSION)

public class DisposableBedMod {
	public static final String MOD_ID = "DisposableBedMod";
	public static final String MOD_NAME = "Disposable Bed Mod";
	public static final String MOD_VERSION = "1.1";
	public static Logger logger = LogManager.getLogger("DisposableBedMod");

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		DbmInfoCore.registerInfo(meta);
		// イベント処理
		MinecraftForge.EVENT_BUS.register(new DbmEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}