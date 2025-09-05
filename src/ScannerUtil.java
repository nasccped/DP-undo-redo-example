import java.util.Scanner;

/** Isolated Scanner features (prompting + trimmed inputs) */
class ScannerUtil {
    private static Scanner sc = new Scanner(System.in);

    protected static String trimmedPrompt(String p) {
        Printer.echo(p);
        return sc.nextLine().trim();
    }
}
