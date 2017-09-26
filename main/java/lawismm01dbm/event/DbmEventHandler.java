package lawismm01dbm.event;

import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;

public class DbmEventHandler {
	/*
	 * プレイヤーが目を覚ましたときに呼び出される処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void WakeUpEvent(PlayerWakeUpEvent event) {
		World world = event.entityPlayer.worldObj;

		// ピースフルの時は、このイベントは動作しない
		if (world.difficultySetting == EnumDifficulty.PEACEFUL) {
			return;
		}

		EntityPlayer player = event.entityPlayer;
		int playerX = (int)player.posX;
		int playerY= (int)player.posY;
		int playerZ = (int)player.posZ;

		// ベッドを使い捨てにするために、空気ブロックを設置
		for (int x = -3; x <= 3; x++) {
			for (int z = -3; z <= 3; z++) {
				for (int y = -3; y <= 3; y++) {

					if (!world.isRemote) {
						if (world.getBlock(playerX +x, playerY +y, playerZ +z) == Blocks.bed) {
							world.setBlockToAir(playerX +x, playerY +y, playerZ +z);
						}
					}

				}
			}
		}

		// プレイヤーの周囲のEntityをListに入れる
		List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player, player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(10.0D, 5.0D, 10.0D));

		// Listが空の場合とnullの場合を除く
		if (list != null && !list.isEmpty()) {
			// Listに入っているEntityを1つずつ確認
			for (int n = 0 ; n < list.size() ; n++) {
				Entity target = (Entity)list.get(n);

				// EntityがベッドのEntityItemの場合
				if (target != null) {
					if (target instanceof EntityItem) {
						EntityItem item = (EntityItem)target;
						if (item.getEntityItem().getItem() == Items.bed) {

							// ベッドを消滅させる
							if (!(event.entity.worldObj.isRemote)) {
								item.setDead();
							}
						}
					}
				}

			}
		}

	}
}