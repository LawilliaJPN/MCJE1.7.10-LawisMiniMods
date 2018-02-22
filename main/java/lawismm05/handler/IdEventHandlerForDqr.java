package lawismm05.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.event.DqrDamageEntityEvent;
import dqr.api.event.DqrDamageMobEvent;
import lawismm05.addon.IdAddons;
import net.minecraft.entity.player.EntityPlayer;

public class IdEventHandlerForDqr {
	/*
	 * dqr.handler.DamageHandlerにフック。
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void InstantDeathEventDqrEntity(DqrDamageEntityEvent event) {
		// System.out.println("[ID]DqrDamageEntityEvent-Phase." + event.damagePhase);

		// 自作mod同士の競合回避のための例外処理
		if ((IdAddons.isPpmLoaded()) && (event.source.getSourceOfDamage() instanceof EntityPlayer)) {
			if (!(event.source.getDamageType() == "explosion.player")) return;
			if (!(event.source.getDamageType() == "indirectMagic")) return;
		}

		if (event.damagePhase == 4) event.retDamage = event.damager.getMaxHealth() +1;
		if (event.damagePhase == 5) event.retMissFlg = false;
		if (8 <= event.damagePhase) event.retDamage = event.damager.getMaxHealth() +1;
	}

	/*
	 * dqr.entity.mobEntity.DqmMobBaseにフック。
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void InstantDeathEventDqrMonster(DqrDamageMobEvent event) {
		// System.out.println("[ID]DqrDamageMobEvent-Phase." + event.damagePhase);

		// 自作mod同士の競合回避のための例外処理
		if ((IdAddons.isPpmLoaded()) && (event.source.getSourceOfDamage() instanceof EntityPlayer)) {
			if (!(event.source.getDamageType() == "explosion.player")) return;
			if (!(event.source.getDamageType() == "indirectMagic")) return;
		}

		if (4 <= event.damagePhase) event.retAbsoluteDamage = event.mob.getMaxHealth() +1;
	}
}
