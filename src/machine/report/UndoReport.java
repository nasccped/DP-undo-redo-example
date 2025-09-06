package machine.report;

/**
 * Report undo success using ternary.
 */
public class UndoReport extends AbstractReport {
    public UndoReport(boolean success) {
        super(success,
              success
              ? "undone successfully."
              : "undo stack is empty.");
    }
}
