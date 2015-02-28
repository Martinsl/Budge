package app.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	public String name;
	public float value;
	public List <Expense> expenses = new ArrayList<Expense>();
	
	public Account (String getName, float getValue) {
		name = getName;
		value = getValue;
	}
	
	public Account (String getName, float getValue, Expense expense) {
		name = getName;
		value = getValue;
		expenses.add(expense);
	}
}