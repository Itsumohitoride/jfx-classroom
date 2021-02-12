package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	private List<UserAccount> users;
	
	public Classroom() {
		users = new ArrayList<>();
	}
	
	public void addUser(String name, String password, String photo, String gender, ArrayList<String> career, String birthday, String fBrowser) {
		users.add(new UserAccount(name,password,photo,gender,career,birthday,fBrowser));
	}
	
	public List<UserAccount> getUsers() {
		return users;
	}
}