package lawismm03.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class LrdEventHandler {
	/*
	 * ブロックが破壊された時に呼び出される処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void BreakBlockEvent(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;

			if (!event.world.isRemote) {
				for (int i = 0; i < 8; i++) {
					player.addChatMessage(new ChatComponentTranslation(""));
				}
			}
		}
	}
}
