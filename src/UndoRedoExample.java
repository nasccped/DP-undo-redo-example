/**
 * This file was generated using kojamp CLI-app
 * Take a look at the official repository (https://github.com/nasccped/kojamp)
 */

public class UndoRedoExample {

    public static void main(String[] args) {
        clear();
        Printer.echoln(green("undo-redo example"));
        Printer.echoln(white("================="));
        Printer.echoln();
        String name = ScannerUtil.trimmedPrompt("What's your name? ");
        Printer.echoln("Hi, \u001b[97;101m" + name + "\u001b[0m");
    }

    private static String green(String text) {
        return String.format("\u001b[92m%s\u001b[0m", text);
    }

    private static String white(String text) {
        return String.format("\u001b[97m%s\u001b[0m", text);
    }

    private static void clear() { Printer.echo("\u001b[2J\u001b[H"); }
}
