package lawismm04.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class PpEventHandler {
	/*
	 * EntityLivingのonUpdateに処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void PlayerAttackEvent(LivingHurtEvent event) {
		if ((event.source.getSourceOfDamage() instanceof EntityPlayer)) {
			// 「プレイヤーが殴って攻撃した時」以外を除外する。
			if (event.source.getDamageType() == "explosion.player") return;

			/* デバッグ用コード
				EntityPlayer player = (EntityPlayer)event.source.getEntity();
				String type = event.source.getDamageType();
				String sod = event.source.getSourceOfDamage().getCommandSenderName();
				player.addChatMessage(new ChatComponentTranslation("DamageType：" + type));
				player.addChatMessage(new ChatComponentTranslation("SourceOfDamage：" + sod));
			*/

			// ダメージを0にする
			event.ammount = 0.0F;
		}
	}
}
