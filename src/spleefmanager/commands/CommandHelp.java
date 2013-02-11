package spleefmanager.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

//Shows help message.
public class CommandHelp extends CommandBase {

	public CommandHelp() {
	}

	@Override
	public String getCommandName() {
		return "spfhelp";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
			var1.sendChatToPlayer("Command list of Spleef Manager Mod \n" +
												"\n\n" +
												"/spfhelp   Show the help \n" +
												"/spfdel Delete the Selceted Area \n" +
												"/spfrestore Restore the Seleceted Area \n" +
												"/spfset Selcet Area"
					);
	}

}
