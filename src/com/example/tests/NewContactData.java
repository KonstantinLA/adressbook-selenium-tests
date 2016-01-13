package com.example.tests;

public class NewContactData implements Comparable<NewContactData> {
	private String firstName;
	private String lastName;
	private String adress;
	private String homePhone;
	private String mobilePhone;
	private String workPhone;
	private String mainEmail;
	private String secondEmail;
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	private int group = 0;
	private String secondAdress;
	private String home;

	public NewContactData(String firstName, String lastName, String adress, String homePhone, String mobilePhone,
			String workPhone, String mainEmail, String secondEmail, String birthDay, String birthMonth,
			String birthYear, int group, String secondAdress, String home) {
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

	@Override
	public int hashCode() {
		int result = 1;
		return result;
	}

	@Override
	public String toString() {
		return "NewContactData [firstName=" + firstName + ", lastName=" + lastName + ", homePhone=" + homePhone
				+ ", mainEmail=" + mainEmail + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewContactData other = (NewContactData) obj;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(NewContactData other) {
		if(this.lastName == null)
		{
			this.lastName = "";
		}
		else if(other.lastName == null)
		{
			other.lastName = "";
		}
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
		
	}

	public NewContactData withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public NewContactData withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public NewContactData withAdress(String adress) {
		this.adress = adress;
		return this;
	}

	public NewContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
	}

	public NewContactData withMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
		return this;
	}

	public NewContactData withWorkPhone(String workPhone) {
		this.workPhone = workPhone;
		return this;
	}

	public NewContactData withMainEmail(String mainEmail) {
		this.mainEmail = mainEmail;
		return this;
	}

	public NewContactData withSecondEmail(String secondEmail) {
		this.secondEmail = secondEmail;
		return this;
	}

	public NewContactData withBirthDay(String birthDay) {
		this.birthDay = birthDay;
		return this;
	}

	public NewContactData withBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
		return this;
	}

	public NewContactData withBirthYear(String birthYear) {
		this.birthYear = birthYear;
		return this;
	}

	public NewContactData withSecondAdress(String secondAdress) {
		this.secondAdress = secondAdress;
		return this;
	}

	public NewContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAdress() {
		return adress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public String getSecondEmail() {
		return secondEmail;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public int getGroup() {
		return group;
	}

	public String getSecondAdress() {
		return secondAdress;
	}

	public String getHome() {
		return home;
	}
	
	
}