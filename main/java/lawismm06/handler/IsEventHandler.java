package lawismm06.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lawismm06.config.IsConfigCore;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class IsEventHandler {
	/*
	 * プレイヤーがブロックを壊した時に呼び出される処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void CancelMiningEvent(BreakEvent event) {
		if ((IsConfigCore.isStone) && (event.block == Blocks.stone)) {
			event.setCanceled(true);
		}
	}


	/*
	 * Entityのドロップアイテムを追加する処理
	 * MinecraftForge.EVENT_BUS.registerで呼び出されるので、staticを付けずに@SubscribeEventを付ける
	 */
	@SubscribeEvent
	public void LivingDropsStoneEvent(LivingDropsEvent event){
		// コンフィグがオフの時は、動作しない
		if (!IsConfigCore.isDrop) return;

        if(!event.entityLiving.worldObj.isRemote) {
        	event.drops.add(new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, new ItemStack(Blocks.cobblestone)));
        }
	}
}