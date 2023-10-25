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

	public String getCurrentValue() {
		return dateFormat.format(currentDate);
	}

	public boolean setValue(String inputDate) {
		try {
			SimpleDateFormat newDate = new SimpleDateFormat("yyyy-MM-dd");
			newDate.setLenient(false);
			currentDate = newDate.parse(inputDate);
			return true;
		} catch (ParseException e) {
			System.out.println("Invalid date. Please use the format yyyy-MM-dd.");
			return false;
		}
	}
}