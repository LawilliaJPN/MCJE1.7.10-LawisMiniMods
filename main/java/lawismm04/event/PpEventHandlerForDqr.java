package lawismm04.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.event.DqrDamageEntityEvent;
import dqr.api.event.DqrDamageMobEvent;
import net.minecraft.entity.player.EntityPlayer;

public class PpEventHandlerForDqr {
	/*
	 * dqr.handler.DamageHandlerにフック。
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void PowerlessPlayerEventDqrEntity(DqrDamageEntityEvent event) {
		if (!(event.source.getSourceOfDamage() instanceof EntityPlayer)) return;
		if (event.source.getDamageType() == "explosion.player") return;
		if (event.source.getDamageType() == "indirectMagic") return;

		if (event.damagePhase == 4) event.retDamage = 0.0F;
		if (8 <= event.damagePhase) event.retDamage = 0.0F;
	}

	/*
	 * dqr.entity.mobEntity.DqmMobBaseにフック。
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void PowerlessPlayerEventDqrMonster(DqrDamageMobEvent event) {
		if (!(event.source.getSourceOfDamage() instanceof EntityPlayer)) return;
		if (event.source.getDamageType() == "explosion.player") return;
		if (event.source.getDamageType() == "indirectMagic") return;

		if (4 <= event.damagePhase) event.retAbsoluteDamage = 0.0F;
	}
}