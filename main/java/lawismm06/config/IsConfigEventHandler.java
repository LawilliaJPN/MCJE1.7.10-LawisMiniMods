package lawismm06.config;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lawismm06.IndestructibleStone;

/*
 * コンフィグ変更を反映させるイベント。
 */
public class IsConfigEventHandler {
	/*
	 * コンフィグが変更されたときに呼び出されるメソッド
	 */
	@SubscribeEvent
	public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		// 変更されたコンフィグがこのmodのものであるとき
		if (event.modID.equals(IndestructibleStone.MOD_ID)) {
			syncConfigAndResetCount();
		}
	}

	/*
	 * 上記メソッドで呼び出されるメソッド。
	 * コンフィグ同期と関連変数のリセット。
	 */
	public static void syncConfigAndResetCount() {
		// コンフィグの同期を行う
		IsConfigCore.syncConfig();
	}
}