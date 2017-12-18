package lawismm00;

import cpw.mods.fml.common.ModMetadata;


/*
 * mcmod.infoと同様の内容。
 * modの情報を登録するためのクラス。
 *
 * preInitで最初に呼び出す。
 */
public class InfoCore {
	public static void registerInfo(ModMetadata meta) {
		meta.modId = LawisMiniMod.MOD_ID;
		meta.name = LawisMiniMod.MOD_NAME;
		meta.description = LawisMiniMod.DESCRIPTION;
		meta.version = LawisMiniMod.MOD_VERSION;
		meta.url = "http://lawiss.com/minecraft-modding/";
		meta.authorList.add("Lawillia");
		meta.credits = "";
		meta.logoFile = "";
		meta.autogenerated = false;
	}
}