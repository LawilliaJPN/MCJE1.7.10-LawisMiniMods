package lawismm02en.config;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lawismm02en.EndersNightmare;
import net.minecraftforge.common.config.Configuration;

/*
 * コンフィグ設定の中心となるクラス。
 */
public class EnConfigCore {
	public static Configuration cfg;

	/* GENERAL Mod全般の設定 */
	public static final String GENERAL = "General";

	// NETHER ネザー
	private static final String NETHER = GENERAL + ".nether";
	public static boolean isNether = false;

	// NETHER ネザー
	private static final String ENDERS_ATTACK = GENERAL + ".endersattack";
	public static boolean isEndersAttack = false;

	/*
	 * preInitにて呼び出すメソッド。
	 * コンフィグの読み込み
	 */
	public static void loadConfig(FMLPreInitializationEvent event) {
		// Configurationのインスタンス化
		cfg = new Configuration(event.getSuggestedConfigurationFile(), EndersNightmare.MOD_VERSION, true);

		// コンフィグの初期化・同期
		initConfig();
		syncConfig();
	}

	/*
	 * コンフィグの初期化
	 */
	private static void initConfig() {
		/* GENERAL Mod全般の設定 */
		cfg.addCustomCategoryComment(GENERAL, "The general settings of  " + EndersNightmare.MOD_NAME + ".");
		cfg.setCategoryLanguageKey(GENERAL, "config.endersnightmare.category.general");

		// NETHER ネザーでの動作有無
		cfg.addCustomCategoryComment(NETHER, "The setting of except overworld night.");
		cfg.setCategoryLanguageKey(NETHER, "config.endersnightmare.category.nether");

		// ENDERS_ATTACK エンダーマンの攻撃によるエンド行き有無
		cfg.addCustomCategoryComment(ENDERS_ATTACK, "The setting of Enders' Nightmare Attack.");
		cfg.setCategoryLanguageKey(ENDERS_ATTACK, "config.endersnightmare.category.enderattack");
	}

	/*
	 * コンフィグの同期
	 */
	public static void syncConfig() {
		/* 変数への反映 */
		// NETHER ネザーでの動作有無
		isNether = cfg.getBoolean("Nether", NETHER, isNether, "If this setting is true, You have Enders' Nightmare outside of OVERWORLD.", "config.endersnightmare.category.nether");
		// ENDERS_ATTACK エンダーマンの攻撃によるエンド行き有無
		isEndersAttack = cfg.getBoolean("Enders' Attack", ENDERS_ATTACK, isEndersAttack, "If this setting is true, You have Enders' Nightmare when you are attacked from Enderman.", "config.endersnightmare.category.enderattack");

		/* コンフィグファイルの保存 */
		cfg.save();
	}
}
