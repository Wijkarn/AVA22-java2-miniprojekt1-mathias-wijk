package clock;

import java.util.Scanner;

import display.Displayable;

public class ClockController {
	private ClockStateEnum currentState;
	private Displayable timeDisplay;
	private Displayable dateDisplay;
	private Scanner scanner;

	public ClockController(Displayable timeDisplay, Displayable dateDisplay) {
		currentState = ClockStateEnum.DISPLAY_TIME;
		this.timeDisplay = timeDisplay;
		this.dateDisplay = dateDisplay;
		scanner = new Scanner(System.in);
	}

	public void run() {
		while (true) {
			System.out.println("""
					Select an action:
					1. Show time
					2. Show date
					3. Change time
					4. Change date
					5. Quit
					""");

			int choice = scanner.nextInt();

			switch (currentState) {
			case DISPLAY_TIME:
				if (choice == 1) {
					System.out.println("Current time: " + timeDisplay.getCurrentValue());
				} else if (choice == 2) {
					currentState = ClockStateEnum.DISPLAY_DATE;
				} else if (choice == 3) {
					System.out.print("Enter new time (HH:mm:ss): ");
					changeValue(timeDisplay, scanner.nextLine());
				}
				break;
			case DISPLAY_DATE:
				if (choice == 2) {
					System.out.println("Current date: " + dateDisplay.getCurrentValue());
				} else if (choice == 3) {
					currentState = ClockStateEnum.DISPLAY_TIME;
				} else if (choice == 4) {
					System.out.print("Enter new date (yyyy-MM-dd): ");
					changeValue(dateDisplay, scanner.nextLine());
				}
				break;
			case CHANGE_TIME:
				System.out.print("Enter new time (HH:mm:ss): ");
				changeValue(timeDisplay, scanner.nextLine());
				currentState = ClockStateEnum.DISPLAY_TIME;
				break;
			case CHANGE_DATE:
				System.out.print("Enter new date (yyyy-MM-dd): ");
				String newDate = scanner.nextLine();
				changeValue(dateDisplay, newDate);
				currentState = ClockStateEnum.DISPLAY_DATE;
				break;
			default:
				System.out.println("Invalid selection. Please try again.");
				break;
			}

			if (choice == 5) {
				System.out.println("Quitting...");
				scanner.close();
				break;
			}
		}
	}

	public void changeValue(Displayable display, String newValue) {
		if (display.setValue(newValue)) {
			currentState = (display == timeDisplay) ? ClockStateEnum.DISPLAY_TIME : ClockStateEnum.DISPLAY_DATE;
		}
	}
}