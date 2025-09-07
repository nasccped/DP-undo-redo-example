package utils;

/**
 * Strategy to be ran with specific types. (I've tried to use static,
 * but I'd fail :^(     )
 */
public interface Strategy<Input, Output> {
    public Output strategy(Input input);
}
