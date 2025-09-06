package machine.report;

/**
 * Report item pushing (always ok).
 */
public class ItemPushReport extends AbstractReport {
    public ItemPushReport() {
        super(true, "item pushed to the machine.");
    }
}
