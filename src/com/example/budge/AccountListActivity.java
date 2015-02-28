package com.example.budge;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import app.models.Account;

public class AccountListActivity extends Base { 

	ListView listView;
	  
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.my_accounts);
	 
	    listView = (ListView) findViewById(R.id.accountsList);
	    AccountAdapter adapter = new AccountAdapter(this, users.get(logedUser).accounts);
	    listView.setAdapter(adapter);
	  }
	  
}

class AccountAdapter extends ArrayAdapter<Account> {
	
	private Context context;
	public  List<Account> accounts;

	public AccountAdapter(Context context, List<Account> accounts) {
		super(context, R.layout.account_row, accounts);
	    this.context   = context;
	    this.accounts = accounts;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
	    LayoutInflater inflater = (LayoutInflater) context
	    		.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
	    View view = inflater.inflate(R.layout.account_row, parent, false);
	    Account account = accounts.get(position);
	    TextView nameView = (TextView) view.findViewById(R.id.row_name);
	    TextView amountView = (TextView) view.findViewById(R.id.row_amount);
	    
	    if (account.value > 0) {
	    	nameView.setTextColor(Color.parseColor("#009933"));
	    	amountView.setTextColor(Color.parseColor("#009933"));
	    } else if (account.value < 0){
	    	nameView.setTextColor(Color.parseColor("#ff0000"));
	    	amountView.setTextColor(Color.parseColor("#ff0000"));
	    }
	    nameView.setText(account.name);
	    amountView.setText("" + account.value);
	    
	    return view;
	}

	@Override
	public int getCount() {
	    return accounts.size();
	}
}

