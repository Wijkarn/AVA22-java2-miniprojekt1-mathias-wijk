package display;

// An interface for objects that can be displayed and have their values updated
public interface Displayable {
	// Method to retrieve the current value as a string
	String getCurrentValue();

	// Method to set a new value from a string and return a boolean indicating success
	boolean setValue(String newValue);
}
