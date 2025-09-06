package machine.report;

/**
 * This variant is useless since it'll never be report (display
 * occurs within the loop only).
 */
public class QuitReport extends AbstractReport {
    public QuitReport() {
        super(true, "quitting...");
    }
}
