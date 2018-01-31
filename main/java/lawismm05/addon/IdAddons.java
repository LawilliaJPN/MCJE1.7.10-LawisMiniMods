package lawismm05.addon;

import cpw.mods.fml.common.Loader;
import lawismm05.InstantDeath;
import lawismm05.handler.IdEventHandlerForDqr;
import net.minecraftforge.common.MinecraftForge;

public class IdAddons {
	// DQRmod（アドオン対象）
	private static boolean DqrLoaded = false;

	/*
	 *  連携先のDQRmodが併用されているかを確認するメソッド
	 *  MOD ID：DQMIIINext
	 */
	public static void loadDQR() {
		if (Loader.isModLoaded("DQMIIINext")) {
			try {
				DqrLoaded = true;

				// イベント処理
				MinecraftForge.EVENT_BUS.register(new IdEventHandlerForDqr());

			} catch (Throwable t) {
				InstantDeath.logger.warn("Failed to load DQRmod");
			}
		}
	}

	/*
	 *  getter
	 */
	public static boolean isDqrLoaded() {
		return DqrLoaded;
	}
}
