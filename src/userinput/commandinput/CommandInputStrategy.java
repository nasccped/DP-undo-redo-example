package userinput.commandinput;

import utils.Strategy;

/**
 * Strategy for CommandInput abstract class. Generate an suitable
 * CommandInput variant from a given String input.
 */
public class CommandInputStrategy
implements Strategy<String, AbstractCommandUserInput> {
    public AbstractCommandUserInput strategy(String input) {
        AbstractCommandUserInput result = null;
        if (input.equalsIgnoreCase("undo") || input.equalsIgnoreCase("u"))
            result = new UndoUserInput();
        else if (input.equalsIgnoreCase("redo") || input.equalsIgnoreCase("r"))
            result = new RedoUserInput();
        else if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q"))
            result = new QuitUserInput();
        return result;
    }
}
