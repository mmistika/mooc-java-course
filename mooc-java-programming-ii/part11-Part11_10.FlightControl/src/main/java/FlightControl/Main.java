package FlightControl;

import java.util.Scanner;

import FlightControl.logic.FlightControl;
import FlightControl.ui.TextUI;

public class Main {

    public static void main(String[] args) {
        // Write the main program here. It is useful to create some classes of your own.
        FlightControl fc = new FlightControl();
        Scanner scanner = new Scanner(System.in);
        new TextUI(fc, scanner).start();
    }
}
