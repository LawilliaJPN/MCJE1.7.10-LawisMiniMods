package lawismm06;

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
import lawismm06.config.IsConfigCore;
import lawismm06.config.IsConfigEventHandler;
import lawismm06.handler.IsEventHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = IndestructibleStone.MOD_ID, name = IndestructibleStone.MOD_NAME, version = IndestructibleStone.MOD_VERSION, guiFactory = "lawismm06.config.IsGuiFactory")

public class IndestructibleStone {
	public static final String DESCRIPTION = "Lawis Mini Mod #06";
	public static final String MOD_ID = "IndestructibleStoneMod";
	public static final String MOD_NAME = "Indestructible Stone Mod";
	public static final String MOD_VERSION = "1.0";
	public static Logger logger = LogManager.getLogger(MOD_ID);

	@Metadata(MOD_ID)
	private static ModMetadata meta;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		// MODの情報の登録
		InfoCore.registerInfo(meta);

		// コンフィグの読み込み
		IsConfigCore.loadConfig(event);

		// イベント処理
		MinecraftForge.EVENT_BUS.register(new IsEventHandler());
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		// ゲーム内コンフィグ変更の反映
		FMLCommonHandler.instance().bus().register(new IsConfigEventHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}