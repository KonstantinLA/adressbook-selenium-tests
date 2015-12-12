package com.example.tests;

public class NewContactData {
	public String firstName;
	public String lastName;
	public String adress;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String mainEmail;
	public String secondEmail;
	public String birthDay;
	public String birthMonth;
	public String birthYear;
	public String group;
	public String secondAdress;
	public String home;

	public NewContactData(String firstName, String lastName, String adress, String homePhone, String mobilePhone,
			String workPhone, String mainEmail, String secondEmail, String birthDay, String birthMonth,
			String birthYear, String group, String secondAdress, String home) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.mainEmail = mainEmail;
		this.secondEmail = secondEmail;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.group = group;
		this.secondAdress = secondAdress;
		this.home = home;
	}
	
	public NewContactData() {}
}