package userinput;

import utils.Strategy;
import userinput.commandinput.CommandInputStrategy;

/**
 * Strategy "factory-like" handler. It receives a String input and
 * returns the suitable UserInput (from AbstractUserInput) variant.
 */
public class UserInputStrategy
implements Strategy<String, AbstractUserInput> {

    /**
     * A String input can refer to integer input or command input
     * also, so, it should have it own CommandInputStrategy.
     */
    private CommandInputStrategy cmdInpStrtg;

    public UserInputStrategy() {
        this.cmdInpStrtg = new CommandInputStrategy();
    }

    /**
     * Build an AbstractUserInput from a String.
     */
    @Override
    public AbstractUserInput strategy(String input) {
        AbstractUserInput result;
        if (isNumeric(input)) result = new NumericUserInput(input);
        else result = cmdInpStrtg.strategy(input);
        return
            // if result still null (non numeric + non valid command)
            (result == null)
                ? new InvalidUserInput(input) // return invalid
                : result; // else, return self
    }

    /**
     * Check if the given input is an valid numeric:
     *
     * WARN: valid numerics (by this machine logic) are
     *  1. Integers
     *  2. Greater or equals to 0
     */
    private boolean isNumeric(String input) {
        if (input.isEmpty()) return false;
        char curr;
        for (int i = 0; i < input.length(); i++) {
            curr = input.charAt(i);
            if (curr < '0' || curr > '9') return false;
        }
        return true;
    }
}
