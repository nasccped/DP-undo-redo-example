package userinput;

/**
 * When the user provides an integer input (add to the machine's
 * stacks).
 *
 * Stores the input since the parent class provides "getValue"
 * method.
 */
public class NumericUserInput extends AbstractGettableUserInput {
    protected NumericUserInput(String value) { super(value); }
}
