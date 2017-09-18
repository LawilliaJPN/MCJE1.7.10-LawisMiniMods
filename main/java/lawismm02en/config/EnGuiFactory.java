package lawismm02en.config;

import java.util.Set;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.GuiConfig;
import lawismm02en.EndersNightmare;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

/*
 * ゲーム内でコンフィグを変更するためのGUI。
 */
public class EnGuiFactory implements IModGuiFactory {
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
			super(parent, (new ConfigElement<Object>(EnConfigCore.cfg.getCategory(EnConfigCore.GENERAL))).getChildElements(), EndersNightmare.MOD_ID, false, false, EndersNightmare.MOD_NAME);
		}
	}
}
