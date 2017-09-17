package lawismm02en;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EnEventHandler {
	/*
	 * EntityLivingのonUpdateに処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void NightmareEvent(LivingUpdateEvent event) {
		EntityLivingBase entity = event.entityLiving;
		World world = entity.worldObj;

		// ピースフルの時は、このイベントは動作しない
		if (world.difficultySetting == EnumDifficulty.PEACEFUL) {
			return;
		}

		// プレイヤーのみ
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;

			// 夜の時
			if (!world.isDaytime()) {
				// エンド以外にいる時
				if (world.provider.dimensionId != 1) {
					// エンドに飛ばされる
					if (!world.isRemote) {
						player.travelToDimension(1);
					}
				}
			}
		}
	}
}