package main;

import clock.ClockController;
import date.DisplayDate;
import display.Displayable;
import time.DisplayTime;

public class Main {

	public static void main(String[] args) {
		Displayable timeDisplay = new DisplayTime();
		Displayable dateDisplay = new DisplayDate();
		ClockController clockController = new ClockController(timeDisplay, dateDisplay);
		clockController.run();
	}

}
