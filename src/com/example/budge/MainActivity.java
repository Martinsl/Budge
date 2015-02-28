package com.example.budge;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import app.models.Account;
import app.models.Expense;
import app.models.User;

public class MainActivity extends Base {
	
	private EditText user;
	private EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		user = (EditText) findViewById(R.id.user);
		password = (EditText) findViewById(R.id.password);
		Expense expenseTest = new Expense("TestExp", "Food", 12);
		Account accountTest = new Account("TestAcc", 555, expenseTest);
		newUser(new User("usr", "123", accountTest));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void loginOnClick(View v) {
		String informedUser = user.getText().toString();
		String informedPass = password.getText().toString();
		int id = getUserIndex(informedUser);
		
		if(userRegistered(informedUser, informedPass, id) > 0) {
			logedUser = id;
			startActivity(new Intent(this, DashboardActivity.class));
		} else {
			String errorMessage = getString(R.string.auth_error);
			Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
		}
	}
	
	public void registerOnClick(View v) {
		String informedUser = user.getText().toString();
		String informedPass = password.getText().toString();
		
		if(getUserIndex(informedUser) < 0 ) {
			newUser(new User(informedUser, informedPass));
			logedUser = users.size()-1;
			startActivity(new Intent(this, DashboardActivity.class));
		}
		String errorMessage = "Username already choosen";
		Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
	}

	public boolean userExist(String informedUser) {
		if (getAccountIndex(informedUser) >= 0) {
			return true;
		}
		return false;
	}
	
	public boolean newUser(User user) {
	      return users.add(user);
	}
	
	public int userRegistered(String name, String pass, int id) {
		
		if (id >= 0) {
			User user = users.get(id);
			
			if(user.password.equals(pass)) {
				return 1;
			}
		}
		return -1;
	}
}
