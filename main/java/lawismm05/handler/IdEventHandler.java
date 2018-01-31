package lawismm05.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lawismm05.addon.IdAddons;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class IdEventHandler {
	/*
	 * EntityLivingのonUpdateに処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void InstantDeathEvent(LivingHurtEvent event) {
		System.out.println("[ID]LivingHurtEvent");
		if (IdAddons.isDqrLoaded()) return;

		System.out.println("[ID]InstantDeath");
		event.ammount = event.entityLiving.getMaxHealth() +1;
	}
}