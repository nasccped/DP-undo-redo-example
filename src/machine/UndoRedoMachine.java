package machine;

import machine.report.AbstractReport;
import machine.report.EmptyReport;
import java.util.Stack;
import utils.Printer;

/**
 * UndoRedo machine main class. It's all static and handled by the
 * Controller's static methods.
 */
public class UndoRedoMachine {

    private static Stack<String> undoStack = new Stack<>();
    private static Stack<String> redoStack = new Stack<>();
    private static AbstractReport report = new EmptyReport();
    private static final MachineStyle ms = new MachineStyle();
    private static boolean quitProcess = false;

    public static void reportStatus() { report.report(); }

    /**
     * Machine's inner values visual (based on git-merge visual).
     */
    public static void printMachineState() {
        int maxItems = String.valueOf(Math.max(undoStack.size(), redoStack.size())).length();
        Printer.echoln(String.format("|> current value: %s%s%s",
                     ms.currentColor,
                     currentValue(),
                     ms.resetColor));
        Printer.echoln(String.format("|> undo stack: %" + maxItems + "d item(s) | %s%s%s",
                     undoStack.size(),
                     ms.undoColor,
                     "|".repeat(undoStack.size()),
                     ms.resetColor));
        Printer.echoln(String.format("|> redo stack: %" + maxItems + "d item(s) | %s%s%s",
                     redoStack.size(),
                     ms.redoColor,
                     "|".repeat(redoStack.size()),
                     ms.resetColor));
    }

    /** Non-panic stack peeking shortcut. */
    private static String currentValue() {
        return undoStack.empty() ? "null" : undoStack.peek();
    }

    /** Execute processes to incoming items */
    protected static void incomingItem(String newItem) {
        redoStack.clear();
        undoStack.push(newItem);
    }

    /**
     * Execute undo action and return status as boolean (true -> Ok,
     * false -> Error).
     */
    protected static boolean undoExecuteAndStatus() {
        if (undoStack.empty()) return false;
        redoStack.push(undoStack.pop());
        return true;
    }

    /**
     * Execute redo action and return status as boolean (true -> Ok,
     * false -> Error).
     */
    protected static boolean redoExecuteAndStatus() {
        if (redoStack.empty()) return false;
        undoStack.push(redoStack.pop());
        return true;
    }

    protected static void updateReport(AbstractReport newReport) {
        report = newReport;
    }

    protected static void setQuit(boolean value) {
        quitProcess = value;
    }

    public static boolean quit() { return quitProcess; }
}
