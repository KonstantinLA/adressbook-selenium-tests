package com.example.tests;

public class NewContactData implements Comparable<NewContactData> {
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
	public int group = 0;
	public String secondAdress;
	public String home;

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
	public String toString() {
		return "NewContactData [firstName=" + firstName + ", lastName=" + lastName + ", adress=" + adress
				+ ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone + ", workPhone=" + workPhone
				+ ", mainEmail=" + mainEmail + ", secondEmail=" + secondEmail + ", birthDay=" + birthDay
				+ ", birthMonth=" + birthMonth + ", birthYear=" + birthYear + ", group=" + group + ", secondAdress="
				+ secondAdress + ", home=" + home + "]";
	}

	@Override
	public int hashCode() {
		int result = 1;
		return result;
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
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mainEmail == null) {
			if (other.mainEmail != null)
				return false;
		} else if (!mainEmail.equals(other.mainEmail))
			return false;
		return true;
	}

	@Override
	public int compareTo(NewContactData other) {
		return this.firstName.toLowerCase().compareTo(other.firstName.toLowerCase());
	}
	
	
}