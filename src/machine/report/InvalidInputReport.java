package machine.report;

import utils.Colors;

/**
 * When the user provides an invalid input (always NOT ok).
 */
public class InvalidInputReport extends AbstractReport {
    public InvalidInputReport(String input) {
        super(false,
              String.format("'%s%s%s' isn't a valid input...",
                            Colors.OTHER_CASE,
                            input,
                            Colors.RESET));
    }
}
