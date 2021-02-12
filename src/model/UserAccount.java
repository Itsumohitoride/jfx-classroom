package model;

import java.util.ArrayList;

public class UserAccount {
	
	private String name;
	private String password;
	private String photo;
	private String gender;
	private ArrayList<String> career;
	private String birthday;
	private String fBrowser;

	public UserAccount(String name, String password, String photo, String gender, ArrayList<String> career,
			String birthday, String fBrowser) {

		this.name = name;
		this.password = password;
		this.photo = photo;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.fBrowser = fBrowser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<String> getCareer() {
		return career;
	}

	public void setCareer(ArrayList<String> career) {
		this.career = career;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getfBrowser() {
		return fBrowser;
	}

	public void setfBrowser(String fBrowser) {
		this.fBrowser = fBrowser;
	}
}

