/**
 * This file was generated using kojamp CLI-app
 * Take a look at the official repository (https://github.com/nasccped/kojamp)
 */

import machine.UndoRedoMachine;
import machine.MachineController;
import userinput.AbstractUserInput;
import userinput.UserInputStrategy;
import userinput.commandinput.QuitUserInput;
import utils.*;

public class UndoRedoExample {

    private static UserInputStrategy inputStrategy = new UserInputStrategy();
    private static AbstractUserInput userInputVariant;

    public static void main(String[] args) {
        String stringInput;
        do {
            // clear + print title and report
            clear();
            Printer.echoln(green("undo-redo example"));
            Printer.echoln(white("================="));
            Printer.echoln();
            UndoRedoMachine.reportStatus();
            Printer.echoln();

            // print state
            UndoRedoMachine.printMachineState();
            Printer.echoln();

            // print options
            printOptions();
            Printer.echoln();

            // get input + update machines through controller
            stringInput = ScannerUtil.trimmedPrompt(" > ");
            userInputVariant = inputStrategy.strategy(stringInput);
            MachineController.handleStringInput(userInputVariant);
            MachineController.updateReport();
        } while (!UndoRedoMachine.quit());

        // bye message
        Printer.echoln();
        Printer.echoln("quitting...\n");
    }

    private static String green(String text) {
        return String.format("%s%s%s",
                             Colors.GREEN,
                             text,
                             Colors.RESET);
    }

    private static String white(String text) {
        return String.format("%s%s%s",
                             Colors.WHITE,
                             text,
                             Colors.RESET);
    }

    private static void clear() { Printer.echo("\u001b[2J\u001b[H"); }

    private static void printOptions() {
        Printer.echoln(" " + green("u") + white("ndo:") + " go back 1 state");
        Printer.echoln(" " + green("r") + white("edo:") + " go next 1 state (stored in redo stack)");
        Printer.echoln(" " + white("[") + green("positive int") + white("]:") + " adds 1 item to the machine");
        Printer.echoln(" " + green("q") + white("uit:") + " ends the program");
    }
}
