package lawismm02en.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lawismm02en.config.EnConfigCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

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
				// コンフィグでオーバーワールド以外が無効になっている場合、オーバーワールド以外では動作しない。
				if ((!EnConfigCore.isNether) && (world.provider.dimensionId != 0)) {
					return;
				}

				// エンド以外にいる時
				if (world.provider.dimensionId != 1) {
					// エンドに飛ばされる
					if (!world.isRemote) {
						player.travelToDimension(1);
						player.addChatMessage(new ChatComponentTranslation("msg.night.txt", new Object[] {}));
					}
				}
			}
		}
	}

	/*
	 * EntityLivingがダメージを受けたときに処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void EnderAttackEvent(LivingHurtEvent event) {
		EntityLivingBase entity = event.entityLiving;
		World world = entity.worldObj;

		// ピースフルの時は、このイベントは動作しない
		if (world.difficultySetting == EnumDifficulty.PEACEFUL) {
			return;
		}

		// コンフィグでエンダーズアタックがオフの時や、エンドでは動作しない
		if ((!EnConfigCore.isEndersAttack) || (world.provider.dimensionId == 1)) {
			return;
		}

		// ダメージが1.0未満なら動作しない
		if (event.ammount < 1.0F) {
			return;
		}

		// プレイヤーのみ
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;

			// エンダーマンに攻撃されたとき
			if (event.source.getSourceOfDamage() instanceof EntityEnderman) {
				// エンドに飛ばされる
				if (!world.isRemote) {
					player.travelToDimension(1);
					player.addChatMessage(new ChatComponentTranslation("msg.endersattack.txt", new Object[] {}));
				}
			}
		}
	}
}