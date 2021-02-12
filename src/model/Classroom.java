package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	private List<UserAccount> accounts;
	
	public Classroom() {
		accounts = new ArrayList<>();
	}
	
	public void addUser(String name, String password, String photo, String gender, ArrayList<String> career, String birthday, String fBrowser) {
		accounts.add(new UserAccount(name,password,photo,gender,career,birthday,fBrowser));
	}
	
	public List<UserAccount> getUsers() {
		return accounts;
	}
	
	public boolean searchUser(String name, String password) {
		
		boolean verific = false;
		
		for(int i = 0; i<accounts.size() && !verific; i++) {
			if(accounts.get(i).getName().equals(name) && accounts.get(i).getPassword().equals(password)) {
				verific = true;
			}
		}
		
		return verific;
	}
}