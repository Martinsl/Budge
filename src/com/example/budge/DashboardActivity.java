package com.example.budge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends Base {
	
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.dashboard);
		
		TextView myTextView = (TextView) findViewById(R.id.textView3);
		myTextView.setText(Integer.toString(totalValue()));
	}
	
	@Override
	protected void onResume() {

	   super.onResume();
	   this.onCreate(null);
	}
	
	public void selectOption(View view){
		
		switch (view.getId()){
			case R.id.new_account:
				startActivity(new Intent(this, AccountActivity.class));
				break;
			case R.id.new_expense:
				if(users.get(logedUser).accounts.size() >= 1) {
					startActivity(new Intent(this, ExpenseActivity.class));
					break;
				} else {
					String accountError = "Please, create an account first"; 
					Toast.makeText(this, accountError, Toast.LENGTH_SHORT).show(); 
					break;
				}
			case R.id.my_accounts:
				startActivity(new Intent(this, AccountListActivity.class));
				break;
		}
	}
}
