package seedu.revision.logic.commands.main;

import seedu.revision.logic.commands.Command;
import seedu.revision.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult().withFeedBack(SHOWING_HELP_MESSAGE).withHelp(true).withExit(false).build();
    }
}
