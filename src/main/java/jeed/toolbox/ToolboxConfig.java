package jeed.toolbox;

import net.minecraft.client.gui.options.components.ToggleableOptionComponent;
import net.minecraft.client.gui.options.data.OptionsPage;
import net.minecraft.client.gui.options.data.OptionsPages;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.Option;
import net.minecraft.core.block.Blocks;

import java.lang.reflect.Field;

public class ToolboxConfig {
	public static OptionsPage toolboxOptions;

	public static void doConfig() {
		toolboxOptions = new OptionsPage("toolbox.options.title", Blocks.GLOWSTONE.getDefaultStack())
			.withComponent(new ToggleableOptionComponent<>(ToolboxOptions.saferSneak))
			.withComponent(new ToggleableOptionComponent<>(ToolboxOptions.hideArmor))
			.withComponent(new ToggleableOptionComponent<>(ToolboxOptions.deerSounds));

		OptionsPages.register(toolboxOptions);
		initConfig();
	}

	public static void initConfig() {
		for (Field field : ToolboxOptions.class.getDeclaredFields()) {
			try {
				Object obj = field.get(null);

				if (obj instanceof KeyBinding key) {
					GameSettings.register(key);
				} else {
					GameSettings.register((Option<?>) obj);
				}
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
