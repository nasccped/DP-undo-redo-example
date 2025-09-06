package userinput;

/**
 * When the user provides an invalid input (not command/Numeric).
 *
 * Stores the input since the parent class provides "getValue"
 * method.
 */
public class InvalidUserInput extends AbstractGettableUserInput {
    protected InvalidUserInput(String value) { super(value); }
}
