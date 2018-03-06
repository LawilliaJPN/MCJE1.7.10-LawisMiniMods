package lawismm06.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm06.IndestructibleStone;
import net.minecraftforge.common.config.Configuration;

/*
 * コンフィグ設定の中心となるクラス。
 */
public class IsConfigCore {
	public static Configuration cfg;

	/* GENERAL Mod全般の設定 */
	public static final String GENERAL = "General";

	// STONE 石ブロック
	private static final String STONE = GENERAL + ".stone";
	public static boolean isStone = true;

	// DROP ドロップ
	private static final String DROP = GENERAL + ".drop";
	public static boolean isDrop = true;

	/*
	 * preInitにて呼び出すメソッド。
	 * コンフィグの読み込み
	 */
	public static void loadConfig(FMLPreInitializationEvent event) {
		// Configurationのインスタンス化
		cfg = new Configuration(event.getSuggestedConfigurationFile(), IndestructibleStone.MOD_VERSION, true);

		// コンフィグの初期化・同期
		initConfig();
		syncConfig();
	}

	/*
	 * コンフィグの初期化
	 */
	private static void initConfig() {
		/* GENERAL Mod全般の設定 */
		cfg.addCustomCategoryComment(GENERAL, "The general settings of " + IndestructibleStone.MOD_NAME + ".");
		cfg.setCategoryLanguageKey(GENERAL, "config.IndestructibleStone.category.general");

		// STONE 石ブロック
		cfg.addCustomCategoryComment(STONE, "The setting of STONE.");
		cfg.setCategoryLanguageKey(STONE, "config.IndestructibleStone.category.stone");

		// DROP ドロップ
		cfg.addCustomCategoryComment(DROP, "The setting of DROP.");
		cfg.setCategoryLanguageKey(DROP, "config.IndestructibleStone.category.drop");
	}

	/*
	 * コンフィグの同期
	 */
	public static void syncConfig() {
		/* 変数への反映 */
		// STONE 石ブロック
		isStone = cfg.getBoolean("STONE", STONE, isStone, "If this setting is true, you can't break stones.", "config.IndestructibleStone.category.stone");
		// DROP ドロップ
		isDrop = cfg.getBoolean("DROP", DROP, isDrop, "If this setting is true, you can get cobblestones from entities.", "config.IndestructibleStone.category.drop");

		/* コンフィグファイルの保存 */
		cfg.save();
	}
}