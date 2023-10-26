package clock;

// Enum defining possible states for the clock
public enum ClockStateEnum {
	DISPLAY_TIME("Display Time (S1)"), // State to display time
	DISPLAY_DATE("Display Date (S2)"), // State to display date
	CHANGE_TIME("Change Time (S3)"), // State to change time
	CHANGE_DATE("Change Date (S4)"); // State to change date

	private final String text;

	// Constructor for each state, takes a descriptive text
	ClockStateEnum(String text) {
		this.text = text;
	}

	// Getter method to retrieve the text for each state
	public String getText() {
		return text;
	}
}
