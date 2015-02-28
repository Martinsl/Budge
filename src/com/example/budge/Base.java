package com.example.budge;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import app.models.Account;
import app.models.User;

public class Base extends Activity {

	public static List <User> users = new ArrayList<User>();
	public static int logedUser;
	
	public int getAccountIndex(String itemName) {
	    for (int i = 0; i < users.get(logedUser).accounts.size(); i++) {
	        Account account = users.get(logedUser).accounts.get(i);
	        if (account.name.equals(itemName)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public int getUserIndex(String itemName) {
	    for (int i = 0; i < users.size(); i++) {
	        User user = users.get(i);
	        if (user.name.equals(itemName)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public int totalValue() {
		int value = 0;
		for (int i = 0; i < users.get(logedUser).accounts.size(); i++) {
			value +=users.get(logedUser).accounts.get(i).value;
		}
		return value;
	}
}