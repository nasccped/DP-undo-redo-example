package machine;

import userinput.AbstractUserInput;
import userinput.NumericUserInput;
import userinput.InvalidUserInput;
import userinput.commandinput.UndoUserInput;
import userinput.commandinput.RedoUserInput;
import userinput.commandinput.QuitUserInput;
import machine.report.*;

/**
 * Modify machine's inner values (since all setters/attributes are
 * protected and/or private).
 */
public class MachineController {

    /** Controller latest report value. */
    private static AbstractReport report = null;

    /** Execute action + set local report based on UserInput. */
    public static void handleStringInput(AbstractUserInput input) {
        if (input instanceof NumericUserInput nui) {
            UndoRedoMachine.incomingItem(nui.getValue());
            report = new ItemPushReport();
        } else if (input instanceof UndoUserInput)
            report = new UndoReport(UndoRedoMachine.undoExecuteAndStatus());
        else if (input instanceof RedoUserInput)
            report = new RedoReport(UndoRedoMachine.redoExecuteAndStatus());
        else if (input instanceof QuitUserInput)
            UndoRedoMachine.setQuit(true);
        // I need to use an 'else if' to bind the object to a variable
        else if (input instanceof InvalidUserInput inv)
            report = new InvalidInputReport(inv.getValue());
    }

    /** Update machine's report based on local report. */
    public static void updateReport() {
        UndoRedoMachine.updateReport(report);
    }
}
