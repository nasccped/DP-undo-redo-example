package machine.report;

import utils.Printer;
import utils.Colors;

/**
 * Stores reports with a personal status (isOk) and it's own message.
 */
public abstract class AbstractReport {
    protected boolean isOk;
    protected String message;

    AbstractReport(boolean isOk, String message) {
        this.isOk = isOk;
        this.message = message;
    }

    AbstractReport() {
        this.isOk = false;
        this.message = null;
    }

    public void report() {
        if (this instanceof EmptyReport)
            Printer.echoln(String.format("%s-----%s: waiting input.",
                                         Colors.YELLOW,
                                         Colors.RESET));
        else {
            Printer.echo(String.format("%s%s%s: ",
                                       isOk ? Colors.GREEN : Colors.RED,
                                       isOk ? "ok" : "error",
                                       Colors.RESET));
            Printer.echoln(message);
        }
    }
}
