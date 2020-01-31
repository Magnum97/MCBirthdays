package me.magnum;

import lombok.Getter;
import me.magnum.birthdays.Command;
import me.magnum.birthdays.SimpleConfig;
import me.magnum.birthdays.SimpleConfigManager;
import org.mineacademy.fo.plugin.SimplePlugin;

public class Birthdays extends SimplePlugin {

	public Birthdays () {
	}

	@Getter
	private static Birthdays birthdays;
	public SimpleConfigManager manager;

	@Getter
	public SimpleConfig mainConfig;

	public SimpleConfig messages;

	@Override
	protected void onPluginStart () {
		birthdays = this;
		registerCommand(new Command());
		String[] comments = {"Multiple lines", "Of nice comments", "Are supported !"};
		String[] header = {"This is super simple", "And highly customizable", "new and fresh SimpleConfig !"};

		this.manager = new SimpleConfigManager(this);

		this.mainConfig = manager.getNewConfig("config.yml", header);
		this.messages = manager.getNewConfig("misc/messages.yml");

		this.mainConfig.set("path1", "value1", comments);
		this.mainConfig.set("path2", "value2", "This is second comment !");
		this.mainConfig.saveConfig();

	}
}



