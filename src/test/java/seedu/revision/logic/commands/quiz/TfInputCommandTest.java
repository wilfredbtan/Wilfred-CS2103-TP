package seedu.revision.logic.commands.quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.revision.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.revision.testutil.TypicalTrueFalse.TF_A;
import static seedu.revision.testutil.TypicalTrueFalse.TF_A_COMMAND;


import seedu.revision.logic.commands.Command;
import seedu.revision.logic.commands.main.CommandResult;
import seedu.revision.logic.parser.exceptions.ParseException;
import seedu.revision.model.Model;
import seedu.revision.model.ModelManager;

public class TfInputCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();


    @Test
    public void execute_tfAnswerTrueCaseInsensitive_correct() throws ParseException {
        Command commandNormal = new TfInputCommand("True", TF_A);
        Command commandUpperCase = new TfInputCommand("TRUE", TF_A);
        Command commandLowerCase = new TfInputCommand("true", TF_A);
        Command commandRandomCase = new TfInputCommand("tRuE", TF_A);

        CommandResult expectedCommandResult = new CommandResult().withFeedBack("correct")
                .withHelp(false).withExit(false).build();
        try {
            assertCommandSuccess(commandNormal, model,
                    expectedCommandResult, expectedModel);
            assertCommandSuccess(commandUpperCase, model,
                    expectedCommandResult, expectedModel);
            assertCommandSuccess(commandLowerCase, model,
                    expectedCommandResult, expectedModel);
            assertCommandSuccess(commandRandomCase, model,
                    expectedCommandResult, expectedModel);
        } catch (Exception e) {
            throw new ParseException(TfInputCommand.MESSAGE_USAGE);
        }
    }

    @Test
    public void execute_tfAnswerFalseCaseInsensitve_wrong() throws ParseException {
        Command commandNormal = new TfInputCommand("False", TF_A);
        Command commandUpperCase = new TfInputCommand("FALSE", TF_A);
        Command commandLowerCase = new TfInputCommand("false", TF_A);
        Command commandRandomCase = new TfInputCommand("faLSE", TF_A);

        CommandResult expectedCommandResult = new CommandResult().withFeedBack("wrong")
                .withHelp(false).withExit(false).build();

        try {
            assertCommandSuccess(commandNormal, model,
                    expectedCommandResult, expectedModel);
            assertCommandSuccess(commandUpperCase, model,
                    expectedCommandResult, expectedModel);
            assertCommandSuccess(commandLowerCase, model,
                    expectedCommandResult, expectedModel);
            assertCommandSuccess(commandRandomCase, model,
                    expectedCommandResult, expectedModel);
        } catch (Exception e) {
            throw new ParseException(TfInputCommand.MESSAGE_USAGE);
        }
    }

    @Test
    public void equals() {
        // same values -> returns true
        Command commandCopy = new TfInputCommand("False", TF_A);
        assertTrue(TF_A_COMMAND.equals(commandCopy));

        // same object -> returns true
        assertTrue(commandCopy.equals(commandCopy));

        assertFalse(commandCopy.equals(null));

        // different type -> returns false
        assertFalse(commandCopy.equals(10));
        assertFalse(commandCopy.equals("TestString"));
    }
}
