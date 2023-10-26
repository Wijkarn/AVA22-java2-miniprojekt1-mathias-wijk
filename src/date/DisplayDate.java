package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import display.Displayable;

public class DisplayDate implements Displayable {
	private SimpleDateFormat dateFormat;
	private Date currentDate;

	public DisplayDate() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		currentDate = new Date();
	}

	// Method to get the current date as a string in the specified format
	public String getCurrentValue() {
		return dateFormat.format(currentDate);
	}

	// Method to set a new date value based on the provided input string
	public boolean setValue(String inputDate) {
		try {
			// If user input is valid it will return true
			SimpleDateFormat newDate = new SimpleDateFormat("yyyy-MM-dd");
			newDate.setLenient(false);
			currentDate = newDate.parse(inputDate);
			return true;
		} catch (ParseException e) {
			System.out.println("Invalid date. Please use the format yyyy-MM-dd.");
		}
		// Return false for unsuccessful update
		return false; 
	}
}
