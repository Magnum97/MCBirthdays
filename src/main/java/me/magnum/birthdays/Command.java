package me.magnum.birthdays;

import me.magnum.Birthdays;
import org.mineacademy.fo.command.SimpleCommand;

public class Command extends SimpleCommand {

	private Birthdays plugin;

	public Command () {
		super("config");
		setMinArguments(2);
		setUsage("<get | set> <key> [value]");
		setDescription("Test config class");
		setPermission("plugin.permission");
		setPermissionMessage("You don't have perms fo' dat yo.");
	}

	public void onCommand () {
		String action = args[0];
		String key = args[1];
		plugin = Birthdays.getBirthdays();
		SimpleConfig config = plugin.getMainConfig();
		if (action.equalsIgnoreCase("get")) {
			Object value = config.get(args[1]);
			checkNotNull(value, args[1] + " is null");
				returnTell("Value of "+key+" is "+ value.toString());
		}
		else if ((action.equalsIgnoreCase("set") && (args.length > 2))) {
			config.set(args[1],args[2]);
			config.saveConfig();
			config.reloadConfig();
			tell(args[1] + " is set to " + args[2]);
		}
		else tell(usageMessage);


	}
}
