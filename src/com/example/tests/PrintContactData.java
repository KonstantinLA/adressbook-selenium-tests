package com.example.tests;

public class PrintContactData implements Comparable<PrintContactData> {
	private String firstAndLastName = "";
	private String homePhone;
	
	public PrintContactData(String firstAndLastName, String homePhone){
		this.firstAndLastName = firstAndLastName;
		this.homePhone = homePhone;
	}
	
	public PrintContactData(){
	}
	
	public PrintContactData withFirstAndLastName(String firstAndLastName) {
		this.firstAndLastName = firstAndLastName;
		return this;
	}
	
	public PrintContactData withHomePhone(String homePhone) {
		this.homePhone = homePhone;
		return this;
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
		PrintContactData other = (PrintContactData) obj;
		if (firstAndLastName == null) {
			if (other.firstAndLastName != null)
				return false;
		} else if (!firstAndLastName.equals(other.firstAndLastName))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(PrintContactData other) {
		return this.firstAndLastName.toLowerCase().compareTo(other.firstAndLastName.toLowerCase());
		
	}

	@Override
	public String toString() {
		return "PrintContactData [firstAndLastName=" + firstAndLastName + ", homePhone=" + homePhone + "]";
	}
}
