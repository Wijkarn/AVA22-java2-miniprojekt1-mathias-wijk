package main;

import clock.ClockController;
import date.DisplayDate;
import display.Displayable;
import time.DisplayTime;

public class Main {

    public static void main(String[] args) {
        // Create objects for time and date display
        Displayable timeDisplay = new DisplayTime();
        Displayable dateDisplay = new DisplayDate();

        // Create a ClockController with the display objects
        ClockController clockController = new ClockController(timeDisplay, dateDisplay);

        // Start the clock controller
        clockController.run();
    }
}
