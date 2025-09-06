package userinput;

/**
 * This class extends the "Main" abstract one but can hold an inner
 * value. It's useful considering that some classes (but not all) can
 * hold value.
 */
abstract class AbstractGettableUserInput
extends AbstractUserInput {

    private String value;

    protected AbstractGettableUserInput(String value) {
        this.value = value;
    }

    public String getValue() { return this.value; }
}
