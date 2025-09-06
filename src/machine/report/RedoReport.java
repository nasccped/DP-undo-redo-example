package machine.report;

/**
 * Report redo success using ternary.
 */
public class RedoReport extends AbstractReport {
    public RedoReport(boolean success) {
        super(success,
              success
              ? "redone successfully."
              : "redo stack is empty.");
    }
}
