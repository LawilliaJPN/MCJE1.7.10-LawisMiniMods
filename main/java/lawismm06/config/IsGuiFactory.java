package lawismm06.config;

import java.util.Set;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.GuiConfig;
import lawismm06.IndestructibleStone;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

/*
 * ゲーム内でコンフィグを変更するためのGUI。
 */
public class IsGuiFactory implements IModGuiFactory {
	@Override
	public void initialize(Minecraft minecraftInstance) {

	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return EnConfigGui.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
		return null;
	}

	public static class EnConfigGui extends GuiConfig {
		public EnConfigGui(GuiScreen parent) {
			super(parent, (new ConfigElement<Object>(IsConfigCore.cfg.getCategory(IsConfigCore.GENERAL))).getChildElements(), IndestructibleStone.MOD_ID, false, false, IndestructibleStone.MOD_NAME);
		}
	}
}