package spleefmanager.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

//Shows help message.
public class CommandHelp extends CommandBase {

	public CommandHelp() {
	}

	@Override
	public String getCommandName() {
		return "sfahelp";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
			var1.sendChatToPlayer("Command list of Spleef Manager Mod \n" +
												"/help   Show the help \n" +
												"/delarea Delete the Selceted Area \n" +
												"/restorearea Restore the Seleceted Area \n" +
												"/setarea Selcet Area"
					);
	}

}
