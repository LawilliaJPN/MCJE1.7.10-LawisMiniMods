package lawismm04.addon;

import cpw.mods.fml.common.Loader;
import lawismm04.PowerlessPlayer;
import lawismm04.event.PpEventHandlerForDqr;
import net.minecraftforge.common.MinecraftForge;

public class PpAddons {
	// DQRmod（アドオン対象）
	private static boolean dqrLoaded = false;

	public static void loadMods() {
		// DQRmodへのアドオン
		loadDQR();
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
				MinecraftForge.EVENT_BUS.register(new PpEventHandlerForDqr());
			} catch (Throwable t) {
				PowerlessPlayer.logger.warn("Failed to load DQRmod");
			}
		}
	}

	/*
	 *  getter
	 */
	public static boolean isDqrLoaded() {
		return dqrLoaded;
	}
}
