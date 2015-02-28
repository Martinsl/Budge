package com.example.budge;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import app.models.Account;

public class AccountActivity extends Base {

	private EditText accountName;
	private EditText accountValue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.new_account);
		
		accountName = (EditText) findViewById(R.id.accountName);
		accountValue = (EditText) findViewById(R.id.accountValue);
	}

	public void selectOption(View view){ 

		switch (view.getId()) {
			case R.id.resetButton:
				accountName.setText("");
				accountValue.setText("");
				break;
			case R.id.acceptButton:
				String name = accountName.getText().toString();
				float value = Float.valueOf( accountValue.getText().toString() );
				String valueFormat = String.format("%.2f", value);
				value = Float.valueOf(valueFormat);
				
				newAccount(new Account(name, value));
				finish();
		}
	}

	public boolean newAccount(Account account) {
	      return users.get(logedUser).accounts.add(account);
	}
}
