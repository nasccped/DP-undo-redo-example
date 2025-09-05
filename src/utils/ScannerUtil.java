package utils;

import java.util.Scanner;

/** Isolated Scanner features (prompting + trimmed inputs) */
public class ScannerUtil {

    private static Scanner sc = new Scanner(System.in);

    public static String trimmedPrompt(String p) {
        Printer.echo(p);
        return sc.nextLine().trim();
    }
}
