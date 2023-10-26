package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import display.Displayable;

public class DisplayTime implements Displayable {
	private SimpleDateFormat timeFormat;
	private Date currentTime;

	public DisplayTime() {
		timeFormat = new SimpleDateFormat("HH:mm:ss");
		currentTime = new Date();
	}

	// Method to get the current time as a string in the specified format
	public String getCurrentValue() {
		return timeFormat.format(currentTime);
	}

	// Method to set a new time value based on the provided input string
	public boolean setValue(String inputTime) {
		try {
			// If user input is valid it will return true
			SimpleDateFormat newTime = new SimpleDateFormat("HH:mm:ss");
			newTime.setLenient(false);
			currentTime = newTime.parse(inputTime);
			return true;
		} catch (ParseException e) {
			System.out.println("Invalid time. Please use the format HH:mm:ss.");
		}
		// Return false for unsuccessful update
		return false;
	}
}
