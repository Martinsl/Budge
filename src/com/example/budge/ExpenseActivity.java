package com.example.budge;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import app.models.Account;
import app.models.Expense;

public class ExpenseActivity extends Base {

	private EditText expenseValue;
	private EditText expenseDescription;
	private Spinner expenseSpinner;
	private Spinner accountName;
	private RadioGroup   incomeExpense;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.expense); 
		
		expenseValue = (EditText) findViewById(R.id.expenseValue);
		expenseDescription = (EditText) findViewById(R.id.expenseDescription);
		expenseSpinner = (Spinner) findViewById(R.id.expenseSpinner);
		accountName = (Spinner) findViewById(R.id.accountSpinner);
		incomeExpense = (RadioGroup)   findViewById(R.id.incomeExpense);
		String[] accountNames = getAccountNames(); //Array to populate Spinner
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.expense_types,
				android.R.layout.simple_spinner_item);
		expenseSpinner.setAdapter(adapter); 
		
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_spinner_item, accountNames);
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		accountName.setAdapter(spinnerArrayAdapter);//Populate spinner with accountNames
	}
	
	public String[] getAccountNames() {
		int size = users.get(logedUser).accounts.size();
		String[] accountNames = new String[size];
		
		for (int i = 0; i < size; i++) {
			Account account = users.get(logedUser).accounts.get(i);
			accountNames[i] = account.name;
		}
		
		return accountNames;
	}
	
	public void createExpense(View view) { 
		
		String description = expenseDescription.getText().toString();
		String accName = accountName.getSelectedItem().toString();
		int accIndex = getAccountIndex(accName);
		String expenseType = expenseSpinner.getSelectedItem().toString();
		float value = Float.valueOf( expenseValue.getText().toString() );
		String valueFormat = String.format("%.2f", value);
		value = Float.valueOf(valueFormat);
		
		if ( incomeExpense.getCheckedRadioButtonId() == R.id.negative) { //It is an expense
			value *= -1;
		}
		
		newExpense(new Expense(description, expenseType, value), accIndex);

		finish();
	}
	
	public boolean newExpense(Expense expense, int accIndex) {
		users.get(logedUser).accounts.get(accIndex).value += expense.value;
		return users.get(logedUser).accounts.get(accIndex).expenses.add(expense);
	}
}