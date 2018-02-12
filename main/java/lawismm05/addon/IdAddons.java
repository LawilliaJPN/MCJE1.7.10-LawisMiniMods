package lawismm05.addon;

import cpw.mods.fml.common.Loader;
import lawismm05.InstantDeath;
import lawismm05.handler.IdEventHandlerForDqr;
import net.minecraftforge.common.MinecraftForge;

public class IdAddons {
	// DQRmod（アドオン対象）
	private static boolean dqrLoaded = false;
	// PowerlessPlayerMod（自作mod）
	private static boolean ppmLoaded = false;

	public static void loadMods() {
		// DQRmodへのアドオン
		IdAddons.loadDQR();
		// 自作mod同士のアドオン
		IdAddons.loadMyMods();
	}

	/*
	 *  連携先のDQRmodが併用されているかを確認するメソッド
	 *  MOD ID：DQMIIINext
	 */
	public static void loadDQR() {
		if (Loader.isModLoaded("DQMIIINext")) {
			dqrLoaded = true;

			try {
				// イベント処理
				MinecraftForge.EVENT_BUS.register(new IdEventHandlerForDqr());
			} catch (Throwable t) {
				InstantDeath.logger.warn("Failed to load DQRmod");
			}
		}
	}

	/*
	 *  自作mod同士が併用されているかを確認するメソッド
	 */
	public static void loadMyMods() {
		if (Loader.isModLoaded("PowerlessPlayerMod")) {
			ppmLoaded = true;
		}
	}

	/*
	 *  getter
	 */
	public static boolean isDqrLoaded() {
		return dqrLoaded;
	}

	public static boolean isPpmLoaded() {
		return ppmLoaded;
	}
}
