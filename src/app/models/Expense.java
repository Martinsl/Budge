package app.models;

public class Expense {
	
	public String description;
	public String type;
	public float value;

	public Expense(String getDescription, String getType, float getValue) {
		description = getDescription;
		type = getType;
		value = getValue;
	}
}