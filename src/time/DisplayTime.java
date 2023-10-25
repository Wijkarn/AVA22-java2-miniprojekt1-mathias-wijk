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

    public String getCurrentValue() {
        return timeFormat.format(currentTime);
    }

    public boolean setValue(String inputTime) {
        try {
            SimpleDateFormat newTime = new SimpleDateFormat("HH:mm:ss");
            newTime.setLenient(false);
            currentTime = newTime.parse(inputTime);
            return true;
        } catch (ParseException e) {
            System.out.println("Invalid time. Please use the format HH:mm:ss.");
            return false;
        }
    }
}