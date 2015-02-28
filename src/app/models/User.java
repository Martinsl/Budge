package app.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	public String name;
	public String password;
	public List <Account> accounts = new ArrayList<Account>();
	
	public User (String getName, String getPass) {
		name = getName;
		password = getPass;
	}
	
	public User (String getName, String getPass, Account account) {
		name = getName;
		password = getPass;
		accounts.add(account);
	}
}
